package ePrize.androidMobile.utils;
import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("DataBaseConfig.properties")
public class DataBaseConfigReader {
	public DataBaseConfigReader() {
        PropertyLoader.newInstance().populate(this);
    }
	//PerfectoMobileAutomation//src//test//resources//PropertyFiles//DataBaseConfig.properties
    @Property(value = "JdbcDriver")
    private String JdbcDriver;

    @Property(value = "DatabaseUrlOLAP")
    private String DatabaseUrlOLAP;

    @Property(value = "DatabaseUrlOLTP")
    private String DatabaseUrlOLTP;

    @Property(value = "DatabaseUrlCORE")
    private String DatabaseUrlCORE;

    @Property(value = "DatabaseName")
    private String DatabaseName;

    @Property(value = "Username")
    private String Username;

    @Property(value = "Password")
    private String Password;

    @Property(value = "SqlQuery")
    private String SqlQuery;

    @Property(value = "eligibleCountSuccess")
    private String eligibleCountSuccess;

    @Property(value = "IneligibleCountFailure")
    private String IneligibleCountFailure;

    @Property(value = "EventNameRegister")
    private String EventNameRegister;

    public String getJdbcDriver() {
        return JdbcDriver;
    }

    public String getDatabaseUrlOLAP() {
        return DatabaseUrlOLAP;
    }

    public String getDatabaseUrlOLTP() {
        return DatabaseUrlOLTP;
    }

    public String getDatabaseUrlCORE() {
        return DatabaseUrlCORE;
    }

    public String getDatabaseName() {
        return DatabaseName;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getSqlQuery() {
        return SqlQuery;
    }

    public String geteligibleCountSuccess() {
        return eligibleCountSuccess;
    }

    public String getIneligibleCountFailure() {
        return IneligibleCountFailure;
    }

    public String getEventNameRegister() {
        return EventNameRegister;
    }

}