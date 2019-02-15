package example.com.day04_shujuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import example.com.day04_shujuku.entity.UserEntity;
import example.com.day04_shujuku.greendao.UserEntityDao;
import example.com.day04_shujuku.utils.GreendaoUtiles;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * 查询
     * */
    public void query(View view) {
        UserEntityDao userEntityDao = GreendaoUtiles.getmInstance().getDaoSession().getUserEntityDao();

        //第一种
        List<UserEntity> userEntities = userEntityDao.loadAll();
        System.out.println(userEntities.size());
        for (UserEntity userEntity : userEntities) {
            System.out.println(userEntity.getName());
        }
        //第二种
        List<UserEntity> userEntities1 = userEntityDao.queryRaw("where mallid=? and name=?", "2", "张三丰");
        System.out.println("usersize:"+userEntities1.size());
        //第三种
        QueryBuilder<UserEntity> studentQueryBuilder =GreendaoUtiles.getmInstance().getDaoSession()
                .queryBuilder(UserEntity.class)
                .where(UserEntityDao.Properties.Id.eq("2"))
                .orderDesc(UserEntityDao.Properties.Id);
        List<UserEntity> list = studentQueryBuilder.list();
        System.out.println("Querylistsize:"+list.size());
    }

    /*
     * 修改
     * */
    public void update(View view) {
        UserEntityDao userEntityDao = GreendaoUtiles.getmInstance().getDaoSession().getUserEntityDao();
        List<UserEntity> userEntities = userEntityDao.loadAll();
        for (UserEntity userEntity : userEntities) {
            if (3 == userEntity.getId()) {
                userEntity.setName("李四");
                userEntityDao.update(userEntity);
            }
        }
    }

    /*
     * 删除
     * */
    public void delete(View view) {
        //全部删除
        UserEntityDao userEntityDao = GreendaoUtiles.getmInstance().getDaoSession().getUserEntityDao();
        //userEntityDao.deleteAll();
        //按照条件删除
        List<UserEntity> userEntities = userEntityDao.loadAll();
        for (UserEntity userEntity : userEntities) {
            if (3 == userEntity.getId()) {
                userEntityDao.delete(userEntity);
            }
        }
    }

    /*
     * 添加
     * */
    public void add(View view) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三");
        UserEntityDao userEntityDao = GreendaoUtiles.getmInstance().getDaoSession().getUserEntityDao();
        userEntityDao.insert(userEntity);
    }
}
