package com.brs.idm.service;


/**
 * @author tiny lin
 * @date 2019/1/31
 */
public interface ILoginService {

    /**
     * mysql数据库中登录用户是否创建。
     * @return
     */
    boolean hasLoginUser(Integer empNo);

    /**
     * 保持用户登录的ip地址信息
     * @param empNo
     * @param ip
     */
    void saveLoginIPAddress(Integer empNo, String ip);

    /**
     * 获取用户当前已经登录的ip地址
     * @param empNo
     * @return
     */
    String  getLoginIpAddress(Integer empNo);


}
