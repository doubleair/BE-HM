package mapper;
/**
 * ��AbstractMapper.java��ʵ��������TODO ��ʵ������ 
 * @author jizhi.qy 2017��11��11�� ����11:05:02
 */
public interface Mapper<M, D> {
    // modelתdo
    D toDO(M m);

    // doתmodel
    M toModel(D d);
}
