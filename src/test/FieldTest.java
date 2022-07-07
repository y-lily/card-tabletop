package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.Field;
import main.java.access.AccessPermission;
import main.java.access.AccessType;


public class FieldTest {

    private Field hand;
    private Field library;
    private Field neutral;


    @Before
    public void init() {
        hand = new Field("hand");
        library = new Field("library");
        neutral = new Field("neutral");

    }


    @Test
    public void whoCanAccessReturnsOwnerIfSetOwner() {
        hand.setAccess(AccessType.VIEW, AccessPermission.OWNER);
        assertEquals(AccessPermission.OWNER,
                hand.whoCanAccess(AccessType.VIEW));
    }


    @Test
    public void whoCanAccessReturnsNobodyIfSetNobody() {
        library.setAccess(AccessType.VIEW, AccessPermission.NOBODY);
        assertEquals(AccessPermission.NOBODY,
                library.whoCanAccess(AccessType.VIEW));
    }


    @Test
    public void whoCanAccessReturnsEverybodyIfSetEverybody() {
        neutral.setAccess(AccessType.VIEW, AccessPermission.EVERYBODY);
        assertEquals(AccessPermission.EVERYBODY,
                neutral.whoCanAccess(AccessType.VIEW));
    }


    @Test
    public void reSettingAccessChangesPermission() {
        library.setAccess(AccessType.VIEW, AccessPermission.EVERYBODY);
        library.setAccess(AccessType.VIEW, AccessPermission.NOBODY);
        assertEquals(AccessPermission.NOBODY,
                library.whoCanAccess(AccessType.VIEW));
    }


    @Test
    public void settingOneAccessDoesNotChangeTheOther() {
        library.setAccess(AccessType.VIEW, AccessPermission.NOBODY);
        library.setAccess(AccessType.MODIFY, AccessPermission.OWNER);
        assertEquals(AccessPermission.NOBODY,
                library.whoCanAccess(AccessType.VIEW));
    }


    @Test
    public void whoCanAccessReturnsUnknownIfPermissionNotSet() {
        assertEquals(AccessPermission.UNKNOWN, library.whoCanAccess(null));
    }
}
