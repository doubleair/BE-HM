package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * 类SuperPageList.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月16日 上午12:14:38
 */
public class SuperPageList<E> implements Iterable<E>, Serializable {

    private static final long serialVersionUID = 1977215788906692135L;

    // 分页对象
    private Paginator paginator;
    // 目标数据列表
    private List<E> dataList;

    /**
     * 创建一个<code>PageList</code>
     */
    public SuperPageList() {
        paginator = new Paginator();
        this.paginator.setItems(0);
        dataList = new ArrayList<E>();
    }

    /**
     * 创建<code>PageList</code>，并将指定<code>Collection</code>中的内容复制到新的list中。
     * 
     * @param c 要复制的<code>Collection</code>
     */
    public SuperPageList(Collection<E> c) {
        this(c, null);
    }

    /**
         * 创建<code>PageList</code>，并将指定<code>Collection</code>中的内容复制到新的list中。
         * 
         * @param c 要复制的<code>Collection</code>
         */
    public SuperPageList(Collection<E> c, Paginator paginator) {
            this.dataList = new ArrayList<E>(c);
            if (paginator == null) {
                this.paginator = new Paginator();
                this.paginator.setItems(0);
            } else {
                this.paginator = paginator;
            }
        }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public List<E> getDataList() {
        return dataList;
    }

    public void setDataList(List<E> dataList) {
        this.dataList = dataList;
    }

    public E first() {
        if (CollectionUtils.isEmpty(dataList)) {
            return null;
        }
        return dataList.get(0);
    }

    /**
     * 结果集是否为空
     * 
     * @return
     */
    public boolean hasResult() {
        return !CollectionUtils.isEmpty(getDataList());
    }

    @Deprecated
    public Iterator<E> iterator() {
        if (getDataList() == null) {
            return new NullIterator<E>();
        }
        return this.getDataList().iterator();
    }

    public static class NullIterator<E> implements Iterator<E> {

        public boolean hasNext() {
            return false;
        }

        public E next() {
            return null;
        }

        public void remove() {}
    }
}
