package example.com.day04_shujuku.entity;

import android.util.Log;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserEntity {

    @Id(autoincrement =true)  //自增
    @Unique   //唯一
    @Property(nameInDb = "mallid")
    private Long id;
    private String name;
    @Generated(hash = 2146553439)
    public UserEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    @Generated(hash = 1433178141)
    public UserEntity() {
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
