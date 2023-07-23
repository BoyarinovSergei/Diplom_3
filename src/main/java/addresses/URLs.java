/*
 * Интерфейс для хранения хостов
 * */

package addresses;

import config.Hosts;
import org.aeonbits.owner.ConfigFactory;

public interface URLs {
    String MAIN_HOST = ConfigFactory.create(Hosts.class).mainUrl();
    String REGISTER_PAGE = ConfigFactory.create(Hosts.class).registerPage();
    String RESTORE_PASSWORD_PAGE = ConfigFactory.create(Hosts.class).restorePassPage();
}
