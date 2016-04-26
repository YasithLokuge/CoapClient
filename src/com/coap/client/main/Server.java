/*******************************************************************************
 * Licenced under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.coap.client.main;

import java.net.SocketException;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.CoapServer;
import org.eclipse.californium.core.server.resources.CoapExchange;



/**
 * The Class CoAPServer.
 * @author Yasith Lokuge
 */
public class Server extends CoapServer {

	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {		
		
		try {
			// create server
			Server server = new Server();
			server.start();
		} catch (SocketException e) {
			System.err.println("Failed to initialize server: " + e.getMessage());
		}
	}

	/**
	 * Instantiates a new co ap server.
	 *
	 * @throws SocketException the socket exception
	 */
	public Server() throws SocketException {

		// provide an instance of a resource
		add(new PublishResource());
	}

	/**
	 * The Class PublishResource.
	 */
	class PublishResource extends CoapResource {

		
		/**
		 * Instantiates a new publish resource.
		 */
		public PublishResource() {
			// set resource identifier
			super("publish");
			// set display name
			getAttributes().setTitle("Publish Resource");
		}

		/* (non-Javadoc)
		 * @see org.eclipse.californium.core.CoapResource#handlePOST(org.eclipse.californium.core.server.resources.CoapExchange)
		 */		
		public void handlePOST(CoapExchange exchange) {			
			System.out.println(exchange.getRequestText());			
			exchange.respond("POST_REQUEST_SUCCESS");			
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.californium.core.CoapResource#handleGET(org.eclipse.californium.core.server.resources.CoapExchange)
		 */
		public void handleGET(CoapExchange exchange) {						
			exchange.respond("GET_REQUEST_SUCCESS");			
		}
	}

}