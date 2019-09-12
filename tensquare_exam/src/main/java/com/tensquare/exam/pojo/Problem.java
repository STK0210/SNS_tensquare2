package com.tensquare.exam.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 实体类
 *
 * @author Administrator
 */
@Entity
@Table(name = "problem")
public class Problem implements Serializable {

    @Id
    private String id;//系统生成的id

    private Integer problemid;//管理员编写的id
    private String problemcontent;//题目内容

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProblemid() {
        return problemid;
    }

    public void setProblemid(Integer problemid) {
        this.problemid = problemid;
    }

    public String getProblemcontent() {
        return problemcontent;
    }

    public void setProblemcontent(String problemcontent) {
        this.problemcontent = problemcontent;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", problemid=" + problemid +
                ", problemcontent='" + problemcontent + '\'' +
                '}';
    }
}
