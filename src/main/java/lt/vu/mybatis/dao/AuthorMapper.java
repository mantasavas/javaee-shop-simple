package lt.vu.mybatis.dao;


import lt.vu.mybatis.model.Author;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface AuthorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Mon Apr 02 14:45:17 EEST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Mon Apr 02 14:45:17 EEST 2018
     */
    int insert(Author record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Mon Apr 02 14:45:17 EEST 2018
     */
    Author selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Mon Apr 02 14:45:17 EEST 2018
     */
    List<Author> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.AUTHOR
     *
     * @mbg.generated Mon Apr 02 14:45:17 EEST 2018
     */
    int updateByPrimaryKey(Author record);
}