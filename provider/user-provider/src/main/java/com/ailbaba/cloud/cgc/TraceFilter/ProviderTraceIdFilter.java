package com.ailbaba.cloud.cgc.TraceFilter;


import com.alibaba.dubbo.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;


@Activate(group = {Constants.PROVIDER, Constants.CONSUMER})
@Slf4j
public class ProviderTraceIdFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //从MDC中获取
        String logId = invocation.getAttachment("traceId");
        MDC.put("traceId", logId);
        Result result = invoker.invoke(invocation);
        return result;
    }
}
