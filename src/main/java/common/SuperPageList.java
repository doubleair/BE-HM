package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.util.CollectionUtils;

/**
 * ��SuperPageList.java��ʵ��������TODO ��ʵ������ 
 * @author jizhi.qy 2017��11��16�� ����12:14:38
 */
public class SuperPageList<E> implements Iterable<E>, Serializable {

    private static final long serialVersionUID = 1977215788906692135L;

    // ��ҳ����
    private Paginator paginator;
    // Ŀ�������б�
    private List<E> dataList;

    /**
     * ����һ��<code>PageList</code>
     */
    public SuperPageList() {
        paginator = new Paginator();
        this.paginator.setItems(0);
        dataList = new ArrayList<E>();
    }

    /**
     * ����<code>PageList</code>������ָ��<code>Collection</code>�е����ݸ��Ƶ��µ�list�С�
     * 
     * @param c Ҫ���Ƶ�<code>Collection</code>
     */
    public SuperPageList(Collection<E> c) {
        this(c, null);
    }

    /**
         * ����<code>PageList</code>������ָ��<code>Collection</code>�е����ݸ��Ƶ��µ�list�С�
         * 
         * @param c Ҫ���Ƶ�<code>Collection</code>
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
     * ������Ƿ�Ϊ��
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
