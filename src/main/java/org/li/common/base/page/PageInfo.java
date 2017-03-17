//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.li.common.base.page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageInfo implements Serializable {
    private int totalCounts = 0;
    private int allPage = 0;
    private int page = 1;
    private Integer isPrev = 0;
    private Integer isNext = 0;
    private List<Integer> listPages = new ArrayList();
    private int pagesize = 20;
    private int startIndex = 0;

    public Integer getIsPrev() {
        return this.isPrev;
    }

    public void setIsPrev(Integer isPrev) {
        this.isPrev = isPrev;
    }

    public Integer getIsNext() {
        return this.isNext;
    }

    public void setIsNext(Integer isNext) {
        this.isNext = isNext;
    }

    public List<Integer> getListPages() {
        return this.listPages;
    }

    public PageInfo() {
    }

    public PageInfo(int page) {
        if (page < 1) {
            page = 1;
        }

        this.page = page;
        this.startIndex = (page - 1) * pagesize;
    }

    public PageInfo(Integer page) {
        if (null == page || page < 1) {
            page = 1;
        }

        this.page = page;
        this.startIndex = (page - 1) * pagesize;
    }

    public PageInfo(int page, int pagesize) {
        if (page < 1) {
            page = 1;
        }

        this.page = page;
        this.pagesize = pagesize;
        this.startIndex = (page - 1) * pagesize;
    }

    public int getTotalCounts() {
        return this.totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
        this.executePage();
    }

    public void executePage() {
        this.startIndex = (page - 1) * this.pagesize;

        if (this.totalCounts > 0) {
            this.allPage = this.totalCounts / this.pagesize;
            if (this.totalCounts % this.pagesize != 0) {
                ++this.allPage;
            }
        }

        int startX = 1;
        if (this.page > 4 && this.page <= this.allPage) {
            startX = this.page - 4;
        }

        if (this.page > 1 && this.page <= this.allPage) {
            this.isPrev = Integer.valueOf(this.page - 1);
        }

        for (int i = startX; i < startX + 10 && i <= this.allPage; ++i) {
            this.listPages.add(Integer.valueOf(i));
        }

        if (this.page < this.allPage) {
            this.isNext = Integer.valueOf(this.page + 1);
        }

    }

    public int getAllPage() {
        return this.allPage;
    }

    public void setAllPage(int allPage) {
        this.allPage = allPage;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        if (page < 1) {
            page = 1;
        }

        this.page = page;
        this.executePage();
    }

    public int getPagesize() {
        return this.pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
        this.executePage();
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }


    public void setListPages(List<Integer> listPages) {
        this.listPages = listPages;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "totalCounts=" + totalCounts +
                ", allPage=" + allPage +
                ", page=" + page +
                ", isPrev=" + isPrev +
                ", isNext=" + isNext +
                ", listPages=" + listPages +
                ", pagesize=" + pagesize +
                ", startIndex=" + startIndex +
                '}';
    }

    public static void main(String[] args) {
//        PageInfo pageInfo = new PageInfo(1, 9);
//        pageInfo.setTotalCounts(60);
//        System.out.println(pageInfo.toString());
//        PageInfo pageInfo2 = new PageInfo();
//        pageInfo2.setPagesize(3);
//        pageInfo2.setPage(2);
//        System.out.println(pageInfo2.toString());
//        PageInfo pageInfo3 = new PageInfo();
//        pageInfo3.setPage(2);
//        pageInfo3.setPagesize(3);
//        System.out.println(pageInfo3.toString());

//        PageInfo pageInfo = new PageInfo(2);
        PageInfo pageInfo = new PageInfo(null);
        System.out.println(pageInfo.toString());
    }
}
