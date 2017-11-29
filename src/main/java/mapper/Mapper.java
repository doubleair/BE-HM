package mapper;
/**
 * 类AbstractMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月11日 上午11:05:02
 */
public interface Mapper<M, D> {
    // model转do
    D toDO(M m);

    // do转model
    M toModel(D d);
}
