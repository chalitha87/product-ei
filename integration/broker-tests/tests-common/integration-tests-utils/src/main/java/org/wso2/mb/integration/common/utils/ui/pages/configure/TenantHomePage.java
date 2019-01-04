/*
 * Copyright (c) 2005-2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.mb.integration.common.utils.ui.pages.configure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.wso2.mb.integration.common.utils.ui.pages.login.LoginPage;
import org.wso2.mb.integration.common.utils.ui.UIElementMapper;

import java.io.IOException;

/**
 * This page represents Tenant Home page in MB management console.
 */
public class TenantHomePage {

    private static final Log log = LogFactory.getLog(TenantHomePage.class);
    private WebDriver driver;

    /**
     * This constructor test whether the web driver is in correct page.
     * @param driver WebDriver
     */
    public TenantHomePage(WebDriver driver){
        this.driver = driver;
        // Check that we're on the right page.
        if (!driver.findElement(By.xpath(UIElementMapper.getInstance()
                .getElement("mb.tenant.home.page.menu.header.xpath"))).getText().contains("Home")) {
            throw new IllegalStateException("This is not the tenant home page");
        }
    }

    /**
     * Logout from home page. Login page is returned
     * @return LoginPage
     * @throws IOException
     */
    public LoginPage logout() throws IOException {
        driver.findElement(By.xpath(UIElementMapper.getInstance().getElement("mb.tenant.sign.out.xpath"))).click();
        return new LoginPage(driver);
    }
}
