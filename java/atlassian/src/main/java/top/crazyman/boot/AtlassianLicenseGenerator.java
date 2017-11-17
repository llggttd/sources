package top.crazyman.boot;


import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Scanner;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;


public class AtlassianLicenseGenerator {
    public static final String CONFLUENCE_SERVER_LICENSE_DESC = "Confluence (Server)";
    public static final String CONFLUENCE_DATA_CENTER_LICENSE_DESC = "Confluence (Data Center)";
    public static final String JIRA_SOFTWARE_SERVER_LICENSE_DESC = "Jira Software (Server)";
    public static final String JIRA_SOFTWARE_DATA_CENTER_LICENSE_DESC = "Jira Software (Data Center)";
    public static final String BITBUCKET_SERVER_LICENSE_DESC = "Bitbucket (Server)";
    public static final String BITBUCKET_DATA_CENTER_LICENSE_DESC = "Bitbucket (Data Center)";
    public static final String BAMBOO_SERVER_LICENSE_DESC = "Bamboo (Server) Unlimited Remote Agents";
    public static final String CRUCIBLE_SERVER_LICENSE_DESC = "Crucible (Server)";
    public static final String FISH_EYE_SERVER_LICENSE_DESC = "FishEye (Server)";
    static String COMMON_LICENSE_CONTENT = "Description=$$licenseDesc$$\n" +
            "ServerID=$$serverid$$\n" +
            "Organisation=$$org$$\n" +
            "ContactEMail=$$email$$\n" +
            "LicenseTypeName=COMMERCIAL\n" +
            "NumberOfUsers=-1\n" +
            "Subscription=true\n" +
            "Evaluation=false\n" +
            "PurchaseDate=2017-11-14\n" +
            "CreationDate=2017-11-14\n" +
            "LicenseExpiryDate=$$license_expiry_date$$\n" +
            "MaintenanceExpiryDate=$$maintenance_expiry_date$$\n" +
            "LicenseID=LIDSEN-L9418768\n" +
            "SEN=SEN-L9418768\n" +
            "licenseVersion=2\n";
    static String CONFLUENCE_SPECIAL_LICENSE_CONTENT = "conf.LicenseEdition=ENTERPRISE\n" +
            "conf.DataCenter=$$data_center$$\n" +
            "conf.active=true\n" +
            "conf.NumberOfUsers=-1\n" +
            "conf.Starter=false\n" +
            "conf.LicenseTypeName=COMMERCIAL";
    static String JIRA_SPECIAL_LICENSE_CONTENT = "greenhopper.LicenseEdition=ENTERPRISE\n" +
            "jira.NumberOfUsers=-1\n" +
            "jira.product.jira-software.active=true\n" +
            "jira.product.jira-software.DataCenter=false\n" +
            "jira.LicenseEdition=ENTERPRISE\n" +
            "greenhopper.LicenseTypeName=COMMERCIAL\n" +
            "jira.product.jira-software.NumberOfUsers=-1\n" +
            "jira.DataCenter=$$data_center$$\n" +
            "jira.product.jira-software.Starter=false\n" +
            "greenhopper.enterprise=true\n" +
            "jira.active=true\n" +
            "jira.LicenseTypeName=COMMERCIAL\n" +
            "greenhopper.active=true";
    static String BITBUCKET_SPECIAL_LICENSE_CONTENT = "stash.LicenseTypeName=COMMERCIAL\n" +
            "stash.DataCenter=$$data_center$$\n" +
            "stash.active=true\n" +
            "stash.NumberOfUsers=-1\n" +
            "stash.Starter=false";
    static String BAMBOO_SPECIAL_LICENSE_CONTENT = "bamboo.LicenseEdition=ENTERPRISE\n" +
            "bamboo.NumberOfBambooLocalAgents=-1\n" +
            "bamboo.active=true\n" +
            "bamboo.NumberOfBambooRemoteAgents=-1\n" +
            "bamboo.NumberOfBambooPlans=-1\n" +
            "bamboo.LicenseTypeName=COMMERCIAL";
    static String CRUCIBLE_SPECIAL_LICENSE_CONTENT = "crucible.LicenseTypeName=COMMERCIAL\n" +
            "crucible.Starter=false\n" +
            "crucible.NumberOfUsers=-1\n" +
            "crucible.active=true";
    static String FISH_SPECIAL_LICENSE_CONTENT = "fisheye.active=true\n" +
            "fisheye.Starter=false\n" +
            "fisheye.LicenseTypeName=COMMERCIAL\n" +
            "fisheye.NumberOfUsers=-1";

    static String LINE_SEPARATOR = System.getProperty("line.separator");
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String publicKeyStr = "MIIBtzCCASwGByqGSM44BAEwggEfAoGBAPv8emgebh3TsH0GTn2re4PPEwAvsvZT\n" +
                "WKsgXQZpHo1VWPTA7lO90wut/UqiCNgHBeu4Wkkfz9Fo2O/9ZwOZQshSGWFiDyAj\n" +
                "cHm2Z/jZ9r6pDNOgEpSNCXx3mj5gfKVB4TsH3oaek99nmHnnAqjPLAYtBJorRHGf\n" +
                "y2zRZrxWTt01AhUA23xPz/thKOk//nfgE9IJVZHHbm8CgYEA3B8OfGysr205wjnW\n" +
                "oLDXdZ2h8QSpqqb6NGgfl9iPkVgOwOI5CL0VHVoVZzElSUXJ9q09khguuTaV/+sD\n" +
                "zfRf5ZaZ5cx64UBH5cFdbcPvBHL5hT9947Mm5kBol0FDxxxYyGtNgeSSy72GcW5I\n" +
                "VdXSDu4Qc7AHrfKamad8Ek2xYoIDgYQAAoGAesQaQrbmhH/NH11mqQ9T1qALieYS\n" +
                "q4qDqi8yDvmWaL4hG3NcNvj1yzjagxYWXZpGqckAG0mQBIhkLS9JuwqYWuMfHnk3\n" +
                "usMcF96Ab7mP3G+76ING+uYwT0LX0WHSAQtDMg6tXApJ/9kK39wQSsaTRa9CmXS8\n" +
                "lPzM6NZAnB+8Bd8=";
        String privateKeyStr = "MIIBSwIBADCCASwGByqGSM44BAEwggEfAoGBAPv8emgebh3TsH0GTn2re4PPEwAv\n" +
                "svZTWKsgXQZpHo1VWPTA7lO90wut/UqiCNgHBeu4Wkkfz9Fo2O/9ZwOZQshSGWFi\n" +
                "DyAjcHm2Z/jZ9r6pDNOgEpSNCXx3mj5gfKVB4TsH3oaek99nmHnnAqjPLAYtBJor\n" +
                "RHGfy2zRZrxWTt01AhUA23xPz/thKOk//nfgE9IJVZHHbm8CgYEA3B8OfGysr205\n" +
                "wjnWoLDXdZ2h8QSpqqb6NGgfl9iPkVgOwOI5CL0VHVoVZzElSUXJ9q09khguuTaV\n" +
                "/+sDzfRf5ZaZ5cx64UBH5cFdbcPvBHL5hT9947Mm5kBol0FDxxxYyGtNgeSSy72G\n" +
                "cW5IVdXSDu4Qc7AHrfKamad8Ek2xYoIEFgIUAxdjU8HJ6rcc2tGoumi5O2r2Ljw=";
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(publicKeyStr.getBytes())));
            System.out.println("public" + publicKey.getAlgorithm());
            privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyStr.getBytes())));
            System.out.println(privateKey.getAlgorithm());
        } catch (Exception e) {
            e.printStackTrace();
        }

        StringBuffer prompt = new StringBuffer();
        prompt.append("Select license type:").append(LINE_SEPARATOR);
        prompt.append("\t11: ").append(CONFLUENCE_SERVER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t12: ").append(CONFLUENCE_DATA_CENTER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t21: ").append(JIRA_SOFTWARE_SERVER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t22: ").append(JIRA_SOFTWARE_DATA_CENTER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t31: ").append(BITBUCKET_SERVER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t32: ").append(BITBUCKET_DATA_CENTER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t4: ").append(BAMBOO_SERVER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t5: ").append(CRUCIBLE_SERVER_LICENSE_DESC).append(LINE_SEPARATOR);
        prompt.append("\t6: ").append(FISH_EYE_SERVER_LICENSE_DESC).append(LINE_SEPARATOR);
        System.out.print(prompt);
        System.out.print(">> Input selected license type code: ");
        int licenseTypeCode = scanner.nextInt();
        switch (licenseTypeCode) {
            case 11:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", CONFLUENCE_SERVER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "unlimited")
                        .replace("$$maintenance_expiry_date$$", "253402257599855");
                CONFLUENCE_SPECIAL_LICENSE_CONTENT = CONFLUENCE_SPECIAL_LICENSE_CONTENT.replace("$$data_center$$", "false");
                break;
            case 12:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", CONFLUENCE_DATA_CENTER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "253402257599855")
                        .replace("$$maintenance_expiry_date$$", "253402257599855");
                CONFLUENCE_SPECIAL_LICENSE_CONTENT = CONFLUENCE_SPECIAL_LICENSE_CONTENT.replace("$$data_center$$", "true");
                break;
            case 21:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", JIRA_SOFTWARE_SERVER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "unlimited")
                        .replace("$$maintenance_expiry_date$$", "253402257599855");
                JIRA_SPECIAL_LICENSE_CONTENT = JIRA_SPECIAL_LICENSE_CONTENT.replace("$$data_center$$", "false");
                break;
            case 22:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", JIRA_SOFTWARE_DATA_CENTER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "253402257599855")
                        .replace("$$maintenance_expiry_date$$", "253402257599855");
                JIRA_SPECIAL_LICENSE_CONTENT = JIRA_SPECIAL_LICENSE_CONTENT.replace("$$data_center$$", "true");
                break;
            case 31:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", BITBUCKET_SERVER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "unlimited")
                        .replace("$$maintenance_expiry_date$$", "253402257599855");
                BITBUCKET_SPECIAL_LICENSE_CONTENT = BITBUCKET_SPECIAL_LICENSE_CONTENT.replace("$$data_center$$", "false");
                break;
            case 32:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", BITBUCKET_DATA_CENTER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "253402257599855")
                        .replace("$$maintenance_expiry_date$$", "253402257599855");
                BITBUCKET_SPECIAL_LICENSE_CONTENT = BITBUCKET_SPECIAL_LICENSE_CONTENT.replace("$$data_center$$", "true");
                break;
            case 4:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", BAMBOO_SERVER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "unlimited")
                        .replace("$$maintenance_expiry_date$$", "4102401599852");
                break;
            case 5:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", CRUCIBLE_SERVER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "unlimited")
                        .replace("$$maintenance_expiry_date$$", "4102401599852");
                break;
            case 6:
                COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$licenseDesc$$", FISH_EYE_SERVER_LICENSE_DESC)
                        .replace("$$license_expiry_date$$", "unlimited")
                        .replace("$$maintenance_expiry_date$$", "4102401599852");
                break;
            default:
                System.out.println("Invalid license type code!");
                System.exit(1);
        }
        System.out.print(">> Input your server id: ");
        String serverId = scanner.next();
        System.out.print(">> Input your organisation name: ");
        String organisation = scanner.next();
        System.out.print(">> Input your email address: ");
        String email = scanner.next();
        COMMON_LICENSE_CONTENT = COMMON_LICENSE_CONTENT.replace("$$serverid$$", serverId)
                .replace("$$org$$", organisation).replace("$$email$$", email);
        String licenseContent = null;
        switch (licenseTypeCode) {
            case 11:
            case 12:
                licenseContent = COMMON_LICENSE_CONTENT + CONFLUENCE_SPECIAL_LICENSE_CONTENT;
                break;
            case 21:
            case 22:
                licenseContent = COMMON_LICENSE_CONTENT + JIRA_SPECIAL_LICENSE_CONTENT;
                break;
            case 31:
            case 32:
                licenseContent = COMMON_LICENSE_CONTENT + BITBUCKET_SPECIAL_LICENSE_CONTENT;
                break;
            case 4:
                licenseContent = COMMON_LICENSE_CONTENT + BAMBOO_SPECIAL_LICENSE_CONTENT;
                break;
            case 5:
                licenseContent = COMMON_LICENSE_CONTENT + CRUCIBLE_SPECIAL_LICENSE_CONTENT;
                break;
            case 6:
                licenseContent = COMMON_LICENSE_CONTENT + FISH_SPECIAL_LICENSE_CONTENT;
                break;
        }
        System.out.println();
        System.out.println("Your license content. Enjoy it!");
        System.out.println();
        System.out.println(licenseContent);
        System.out.println();
        System.out.println("---------------------------------------------------------------");
        System.out.println(getLicense(licenseContent));
        System.out.println("---------------------------------------------------------------");
    }

    static PublicKey publicKey;
    static PrivateKey privateKey;
    static byte[] licenseTextPrefix = {13, 14, 12, 10, 15};

    static String getLicense(String licenseContent) throws Exception {
        byte[] licenseTextBytes = licenseContent.getBytes("UTF-8");

        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(baos2, deflater);
        deflaterOutputStream.write(licenseTextBytes);
        deflaterOutputStream.close();
        byte[] licenseTextBytesZiped = baos2.toByteArray();

        Signature signature = Signature.getInstance("SHA1withDSA");
        signature.initSign(privateKey);
        signature.update(licenseTextPrefix);
        signature.update(licenseTextBytesZiped);
        byte[] sign = signature.sign();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(licenseTextBytesZiped.length + licenseTextPrefix.length);
        dos.write(licenseTextPrefix);
        dos.write(licenseTextBytesZiped);
        dos.write(sign);

        dos.close();
        byte[] licenseContentBytes = baos.toByteArray();
        String licenseContentBase64 = new String(Base64.encodeBase64(licenseContentBytes));
        String licenseContentWithVersion = licenseContentBase64 + "X02";
        return licenseContentWithVersion + Integer.toString(licenseContentBase64.length(), 31);
    }
}