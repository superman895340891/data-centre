package com.ailbaba.cloud.cgc.TraceFilter;


import com.alibaba.dubbo.common.Constants;
import lombok.extern.slf4j.Slf4j;


import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

import java.util.Map;

@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
@Slf4j
public class ProviderTraceIdFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        //从MDC中获取
        String logId = MDC.get("traceId");
        log.info("traceId{}",logId);
        Map<String, String> attachments = invocation.getAttachments();
        attachments.put("traceId", logId);
        Result result = null;
        //before filter
        result = invoker.invoke(invocation);
        return result;

    }
}
