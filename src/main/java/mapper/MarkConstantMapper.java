package mapper;

import dataObject.MarkConstantDO;
import model.MarkConstantModel;
import org.springframework.stereotype.Repository;

/**
 * 类MarkConstantMapper.java的实现描述：TODO 类实现描述 
 * @author jizhi.qy 2017年11月27日 下午9:27:17
 */
@Repository
public class MarkConstantMapper implements Mapper<MarkConstantModel, MarkConstantDO> {

    @Override
    public MarkConstantDO toDO(MarkConstantModel m) {
        MarkConstantDO d = new MarkConstantDO();
        d.setId(m.getId());
        d.setName(m.getName());
        d.setCnName(m.getCnName());
        d.setCategory(m.getCategory());
        return d;
    }

    @Override
    public MarkConstantModel toModel(MarkConstantDO d) {
        MarkConstantModel m = new MarkConstantModel();
        m.setId(d.getId());
        m.setCnName(d.getCnName());
        m.setName(d.getName());
        m.setCategory(d.getCategory());
        return m;
    }

}
