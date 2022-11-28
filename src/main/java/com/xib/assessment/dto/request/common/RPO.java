package com.xib.assessment.dto.request.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
@NoArgsConstructor
public class RPO<D> {
    private D data;

    private MetaRPO meta;

    public RPO(D data) {
        this.data = data;
    }

    public void fromPage(Page p, QueryRQO q) {
        if (null == p)
            return;
        MetaRPO meta = new MetaRPO();
        if (null != q) {
            meta.setCurrent(q.getPage());
            meta.setSize(q.getSize());
            meta.setQuery(q.getQuery());
        } else {
            meta.setCurrent(0);
            meta.setSize(10);
            meta.setQuery(null);
        }

        if (null != p) {
            meta.setPages(p.getTotalPages());
            meta.setItems(p.getTotalElements());
            meta.setNumber(p.getNumberOfElements());
        }
        this.meta = meta;
    }
}
