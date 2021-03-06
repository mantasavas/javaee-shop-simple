package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Manufacturer;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ManufacturerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    int insert(Manufacturer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    Manufacturer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    List<Manufacturer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MANUFACTURER
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    int updateByPrimaryKey(Manufacturer record);
}