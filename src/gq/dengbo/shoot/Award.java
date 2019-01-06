package gq.dengbo.shoot;

/**
 * 奖励接口
 * @author DengBo
 *
 */
public interface Award {
    public int DOUBLE_FIRE = 0; // 火力值
    public int LIFE = 1;        // 命
    /**
     * 获得奖励类型（0或者1）
     * @return
     */
    public int getAwardType();  
    
    
}
