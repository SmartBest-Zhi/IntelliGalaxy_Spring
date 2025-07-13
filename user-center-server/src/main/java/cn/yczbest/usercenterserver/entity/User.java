package cn.yczbest.usercenterserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author SmartBest_Zhi
 * @since 2024-07-13
 */
@Getter
@Setter
@TableName("t_user")
@Schema(name = "User", description = "")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "手机号")
    @TableId(value = "tel", type = IdType.AUTO)
    private String tel;

    @Schema(description = "用户昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "密码")
    @TableField("password")
    private String password;

    @Schema(description = "邮箱")
    @TableField("email")
    private String email;

    @Schema(description = "角色ID")
    @TableField("role_id")
    private Long roleId;

    @Schema(description = "创建日期时间")
    @TableField("create_at")
    private LocalDateTime createAt;

    @Schema(description = "创建者")
    @TableField("create_by")
    private String createBy;

    @Schema(description = "修改日期时间")
    @TableField("update_at")
    private LocalDateTime updateAt;

    @Schema(description = "修改者")
    @TableField("update_by")
    private String updateBy;

    @Override
    public Serializable pkVal() {
        return this.tel;
    }
}
