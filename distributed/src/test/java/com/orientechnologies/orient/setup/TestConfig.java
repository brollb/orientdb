package com.orientechnologies.orient.setup;

import java.util.List;

// A test config defines the set of nodes (by ID) in the cluster and their configurations.
public interface TestConfig {
  List<String> getServerIds();

  // Used for deploying the config in a local setup.
  String getLocalConfigFile(String serverId);

  // Used for deploying the config in a Kubernetes setup.
  K8sServerConfig getK8sConfigs(String serverId);
}
