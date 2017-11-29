package param;

/**
 * 类PagableParam.java的实现描述：分页参数
 * 
 * @author jizhi.qy 2017年11月12日 下午10:51:54
 */
public class PagableParam {
    private Integer page;
    private Integer pageSize = 20;
    private boolean countNeeded = false;

    public Integer getStartNum() {
        if (page == null || page <= 0) {
            page = 1;
        }
        if (pageSize == null || pageSize <= 0) {
            return 0;
        }
        return (page - 1) * pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        if (page == null) {
            return 0;
        }
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public boolean isPaged() {
        return pageSize != null;
    }

    public boolean isCountNeeded() {
        return countNeeded;
    }

    /**
     * 
     * @param countNeeded
     * @param pageSize
     */
    public void setCountNeeded(boolean countNeeded, final Integer pageSize) {
        this.countNeeded = countNeeded;
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
    }

    public void setCountNeeded(boolean countNeeded) {
        this.countNeeded = countNeeded;
    }
}
