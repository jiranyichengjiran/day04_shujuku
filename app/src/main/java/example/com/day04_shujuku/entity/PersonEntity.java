package example.com.day04_shujuku.entity;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class PersonEntity {
    @Id(autoincrement =true)  //自增
    @Unique   //唯一
    private Long id;
    private String name;
    @Generated(hash = 1587502937)
    public PersonEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 69356185)
    public PersonEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
