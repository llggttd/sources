package com.xxl.conf.core.factory;

import com.xxl.conf.core.core.XxlConfLocalCacheConf;
import com.xxl.conf.core.core.XxlConfMirrorConf;
import com.xxl.conf.core.core.XxlConfRemoteConf;
import com.xxl.conf.core.listener.XxlConfListenerFactory;
import com.xxl.conf.core.listener.impl.BeanRefreshXxlConfListener;

/**
 * XxlConf Base Factory
 *
 * @author xuxueli 2015-9-12 19:42:49
 */
public class XxlConfBaseFactory {

    /**
     * init
     *
     * @param adminAddress
     * @param env
     */
    public static void init(String adminAddress, String env, String accessToken,
                            String mirrorfile) {
        // init
        // init remote util
        XxlConfRemoteConf.init(adminAddress, env, accessToken);
        // init mirror util
        XxlConfMirrorConf.init(mirrorfile);
        // init cache + thread, cycle refresh + monitor
        XxlConfLocalCacheConf.init();
        // listener all key change
        XxlConfListenerFactory.addListener(null, new BeanRefreshXxlConfListener());

    }

    /**
     * destory
     */
    public static void destroy() {
        XxlConfLocalCacheConf.destroy();
    }

}
