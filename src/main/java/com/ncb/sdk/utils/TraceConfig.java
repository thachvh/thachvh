package com.ncb.sdk.utils;

import io.jaegertracing.Configuration;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import org.apache.logging.log4j.ThreadContext;

public class TraceConfig {
    public static Span createTrace(String operationName){
        Configuration.SamplerConfiguration samplerConfig = Configuration.SamplerConfiguration.fromEnv()
                .withType("const")
                .withParam(1);
        Configuration.ReporterConfiguration reporterConfig = Configuration.ReporterConfiguration.fromEnv()
                .withLogSpans(true);

        Configuration config = new Configuration("ncb-sdk")
                .withSampler(samplerConfig)
                .withReporter(reporterConfig);

        Tracer tracer = config.getTracer();

        GlobalTracer.registerIfAbsent(tracer);

        Span span = tracer.buildSpan(operationName).start();

        String traceId = span.context().toTraceId();
        String spanId = span.context().toSpanId();
        ThreadContext.put("traceId", traceId);
        ThreadContext.put("spanId", spanId);
        return span;
    }

    public static void finishSpan(Span span){
        span.finish();
        ThreadContext.remove("traceId");
        ThreadContext.remove("spanId");
    }

}
