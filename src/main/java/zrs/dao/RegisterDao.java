package zrs.dao;

import zrs.pojo.Register;
import zrs.util.BeanListHandler;
import zrs.util.DataSourceUtils;
import zrs.util.JDBCTemplate;
import zrs.util.ScalarHandler;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author rsZheng
 */
public class RegisterDao {
    private JDBCTemplate jdbcTemplate = new JDBCTemplate(DataSourceUtils.getDataSource());

    /**
     * 挂号功能
     * @param register
     * @return
     */
    public int addRegister(Register register){
        String sql="insert into register (pid,did,mid,uid,creation_time) VALUES(?,?,?,?,?)";
        int update = jdbcTemplate.update(sql,register.getPid(),register.getDid(),register.getMid(),register.getUid(),
                register.getCreation_time());
        return update;
    }

    /**
     * 查询全部病历
     * @return
     */
    public List<Register> queryAll(){
        String sql="select * from register";
        List<Register> registerList = jdbcTemplate.queryForList(sql, new BeanListHandler<>(Register.class));
        return registerList;
    }

    /**
     * 根据病人id查询其未付款列表
     * @param id
     * @return
     */
    public List<Register> findNoPayListByPId(int id){
        String sql="SELECT * from register where pid = ? and is_payment = '未付款'";
        List<Register> registerList = jdbcTemplate.queryForList(sql,new BeanListHandler<>(Register.class),id);
        return registerList;
    }

    /**
     * 通过病人id查询挂了多少个医生的号
     * @param id
     * @return 挂号费，一个医生号10元
     */
    public long getDoctor(int id){
        String sql="select count(did) from register where pid = ?";
        Long aLong = jdbcTemplate.queryForScalar(sql,new ScalarHandler<Long>(),id);
        return aLong * 10;
    }

    /**
     * 通过病人id计算药品总价
     * @param id
     * @return
     */
    public long getMedicineSum(int id){
        // 药品表和病历表内连接查询指定病人id下的药品总价
        String sql="select sum(price) from medicine m\n" +
                "INNER JOIN register r\n" +
                "on m.id=r.mid\n" +
                "where pid=?";
        Long aLong = jdbcTemplate.queryForScalar(sql,new ScalarHandler<Long>(),id);
        return aLong;
    }

    /**
     * 扣费，更新病人余额
     * 从病人余额扣除费用
     * @param num
     * @param id
     * @return
     */
    public int updateBalance(long num,int id){
        String sql="update patient set balance = balance - ? where id = ?";
        int update = jdbcTemplate.update(sql,num,id);
        return update;
    }

    /**
     * 更新缴费后的订单状态
     * 设置订单“已付款”状态
     * 将指定id的订单修改为“已付款”，避免一个订单重复缴费
     * @param id
     * @return
     */
    public int updateIs_payment(int id){
        String sql = "update register set is_payment = '已付款' where pid = ?";
        int update=jdbcTemplate.update(sql,id);
        return update;
    }

    public static void main(String[] args) throws ParseException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time); // 2022-11-23 22:01:49

        LocalDateTime ldf = LocalDateTime.parse(localTime,df);
        System.out.println(ldf);
    }
}
