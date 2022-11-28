package com.xib.assessment.dto.base;

public abstract class BaseResponse<DBO, Response extends BaseResponse<DBO, Response>> {

    public abstract Response from(DBO dbo);
}
