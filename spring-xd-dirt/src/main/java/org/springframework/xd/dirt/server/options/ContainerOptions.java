/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.dirt.server.options;

import javax.validation.constraints.NotNull;

import org.kohsuke.args4j.Option;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.xd.dirt.server.options.FromResourceLocationOptionHandlers.DistributedControlTransportOptionHandler;
import org.springframework.xd.dirt.server.options.FromResourceLocationOptionHandlers.DistributedDataTransportOptionHandler;


/**
 * Holds configuration options that are valid for the Container node, when using distributed mode.
 * 
 * @author Eric Bottard
 * @author David Turanski
 */
@ConfigurationProperties
public class ContainerOptions extends CommonDistributedOptions {


	@Option(name = "--transport", handler = DistributedDataTransportOptionHandler.class,
			usage = "The transport to use for data messages (from node to node)")
	private String transport;

	@Option(name = "--hadoopDistro", usage = "The Hadoop distribution to be used for HDFS access")
	private HadoopDistro distro;

	@Option(name = "--controlTransport", aliases = { "--control-transport" },
			handler = DistributedControlTransportOptionHandler.class,
			usage = "The transport to use for control messages (between admin and nodes)")
	private String controlTransport;

	public void setXD_TRANSPORT(String transport) {
		this.transport = transport;
	}

	public String getXD_TRANSPORT() {
		return this.transport;
	}

	public void setHADOOP_DISTRO(HadoopDistro distro) {
		this.distro = distro;
	}

	public HadoopDistro getHADOOP_DISTRO() {
		return this.distro;
	}

	public void setXD_CONTROL_TRANSPORT(String controlTransport) {
		this.controlTransport = controlTransport;
	}

	@NotNull
	public String getXD_CONTROL_TRANSPORT() {
		return controlTransport;
	}
}
