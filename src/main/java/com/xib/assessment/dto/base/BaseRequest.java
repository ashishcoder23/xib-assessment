package com.xib.assessment.dto.base;

public abstract class BaseRequest<DBO, Request extends BaseRequest<DBO, Request>> {
    public abstract DBO to();

    public abstract DBO to(DBO dbo);
}
