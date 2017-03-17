//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.li.common.base.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagerControl<T> implements Serializable {
    private List<T> entityList = new ArrayList<T>();
    private PageInfo pageInfo;
    private Integer draw;

    public PagerControl() {
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }



    public PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getEntityList() {
        return this.entityList;
    }

    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }

    public String toString() {
        return "PagerControl [entityList=" + this.entityList + ", pageInfo=" + this.pageInfo + "]";
    }
}
