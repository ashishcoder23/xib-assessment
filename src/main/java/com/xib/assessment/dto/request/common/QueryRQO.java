package com.xib.assessment.dto.request.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class QueryRQO {

    private String query;

    private Integer page;

    private Integer size;

    public String getQuery() {
        if (null != query && query.isEmpty())
            return null;
        if (null != query)
            query = query.trim();
        return query;
    }

    public String getQ() {
        return getQuery();
    }

    public Integer getPage() {
        return (null != page) ? page : 0;
    }

    public Integer getSize() {
        return (null != size) ? size : 10;
    }

    public Pageable getPageable() {
        return PageRequest.of(getPage(), getSize());
    }

    public Pageable getPageable(String sort, Sort.Direction direction) {
        return PageRequest.of(getPage(), getSize(), direction, sort);
    }
}
