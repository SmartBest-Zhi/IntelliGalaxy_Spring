package cn.yczbest.usercenterserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
@TableName("t_privilege")
@Schema(name = "Privilege", description = "")
public class Privilege extends Model<Privilege> {

    private static final long serialVersionUID = 1L;

    @Schema(description = "角色ID")
    @TableField("role_id")
    private String roleId;

    @Schema(description = "权限ID")
    @TableId(value = "permission_id", type = IdType.AUTO)
    private String permissionId;

    @Override
    public Serializable pkVal() {
        return this.permissionId;
    }
}
