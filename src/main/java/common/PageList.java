package common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * 类PageList.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月15日 下午11:53:43
 */
public class PageList<E> extends SuperPageList<E> {
    private Paginator paginator;
    private List<E> dataList;

    public PageList() {
        paginator = new Paginator();
        this.paginator.setItems(0);
        dataList = new ArrayList<E>();
        super.setPaginator(this.paginator);
        super.setDataList(this.dataList);
    }

    public PageList(Collection<E> c) {
        this(c, null);
    }

    public PageList(Collection<E> c, Paginator paginator) {
        this.dataList = new ArrayList<E>(c);
        if (paginator == null) {
            this.paginator = new Paginator();
            this.paginator.setItems(0);
        } else {
            this.paginator = paginator;
        }
        super.setPaginator(this.paginator);
        super.setDataList(this.dataList);
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
        super.setPaginator(paginator);
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
        super.setDataList(dataList);
    }

    public E first() {
        if (CollectionUtils.isEmpty(dataList)) {
            return null;
        }
        return dataList.get(0);
    }
}
