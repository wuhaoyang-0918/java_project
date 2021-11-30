package com.demo.service;

/**
 * @author why
 * @date 2021/10/19 13:32
 * @PackageName com.demo.service
 * @description
 */
public interface AccountService {
    /**
     * 转账
     * @param outId 转出账户的id
     * @param inId 转出账户的id
     * @param money 转账金额
     */
    public void transfer(Integer outId,Integer inId,Double money);

    public void log();

}
