package me.tartard.alfresco;

import org.alfresco.query.PagingRequest;
import org.alfresco.query.PagingResults;
import org.alfresco.rad.test.AbstractAlfrescoIT;
import org.alfresco.rad.test.AlfrescoTestRunner;
import org.alfresco.repo.security.authentication.AuthenticationUtil;
import org.alfresco.repo.security.authority.AuthorityInfo;
import org.alfresco.service.cmr.security.AuthorityService;
import org.alfresco.service.cmr.security.AuthorityType;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * 
 * @author ahausherr 
 */
@RunWith(AlfrescoTestRunner.class)
public class GetAuthorityInfoIT extends AbstractAlfrescoIT {
    
    @Test
    public void test() {
        AuthenticationUtil.setAdminUserAsFullyAuthenticatedUser();
        AuthorityService authorityService = getServiceRegistry().getAuthorityService();

        PagingResults<AuthorityInfo> res = authorityService.getAuthoritiesInfo(AuthorityType.GROUP, null, null, null, false, new PagingRequest(100, 100));
        List<AuthorityInfo> page = res.getPage();
        
        assertNotNull("Expecting empty page.", page);
        assertEquals("Expecting empty page.", 0, page.size());
    }
    
    
}
