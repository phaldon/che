/*
 * Copyright (c) 2012-2017 Red Hat, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.plugin.maven.client.wizard;

import static org.eclipse.che.ide.ext.java.shared.Constants.JAVA_CATEGORY;
import static org.eclipse.che.plugin.maven.shared.MavenAttributes.MAVEN_ID;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.eclipse.che.ide.api.project.MutableProjectConfig;
import org.eclipse.che.ide.api.project.type.wizard.ProjectWizardRegistrar;
import org.eclipse.che.ide.api.wizard.WizardPage;

/**
 * Provides information for registering Maven project type into project wizard.
 *
 * @author Artem Zatsarynnyi
 */
public class MavenProjectWizardRegistrar implements ProjectWizardRegistrar {
  private final List<WizardPage<MutableProjectConfig>> wizardPages;

  @Inject
  public MavenProjectWizardRegistrar(MavenPagePresenter mavenPagePresenter) {
    wizardPages = new ArrayList<>();
    wizardPages.add(mavenPagePresenter);
  }

  @NotNull
  public String getProjectTypeId() {
    return MAVEN_ID;
  }

  @NotNull
  public String getCategory() {
    return JAVA_CATEGORY;
  }

  @NotNull
  public List<? extends WizardPage<MutableProjectConfig>> getWizardPages() {
    return wizardPages;
  }
}
