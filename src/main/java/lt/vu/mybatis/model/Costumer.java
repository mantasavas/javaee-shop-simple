package lt.vu.mybatis.model;

public class Costumer {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COSTUMER.PERSONALCODE
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    private Integer personalcode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COSTUMER.NAME
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COSTUMER.SURNAME
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    private String surname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COSTUMER.PERSONALCODE
     *
     * @return the value of PUBLIC.COSTUMER.PERSONALCODE
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    public Integer getPersonalcode() {
        return personalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COSTUMER.PERSONALCODE
     *
     * @param personalcode the value for PUBLIC.COSTUMER.PERSONALCODE
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    public void setPersonalcode(Integer personalcode) {
        this.personalcode = personalcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COSTUMER.NAME
     *
     * @return the value of PUBLIC.COSTUMER.NAME
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COSTUMER.NAME
     *
     * @param name the value for PUBLIC.COSTUMER.NAME
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COSTUMER.SURNAME
     *
     * @return the value of PUBLIC.COSTUMER.SURNAME
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COSTUMER.SURNAME
     *
     * @param surname the value for PUBLIC.COSTUMER.SURNAME
     *
     * @mbg.generated Mon Apr 02 17:00:15 EEST 2018
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
}