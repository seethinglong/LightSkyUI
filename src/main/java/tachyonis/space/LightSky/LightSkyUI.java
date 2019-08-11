/*
 * =============================================================================
 *
 *   Copyright (c) 2017, Daniel Fernandez (http://github.com/danielfernandez)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
package tachyonis.space.LightSky;

import tachyonis.space.LightSky.agents.MatchCommentAgent;
import tachyonis.space.LightSky.agents.MatchEventAgent;
import tachyonis.space.LightSky.business.entities.MatchComment;
import tachyonis.space.LightSky.business.entities.MatchEvent;
import tachyonis.space.LightSky.data.Data;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class LightSkyUI {


	@Bean
	public ApplicationRunner initialize(final ReactiveMongoTemplate mongoTemplate) {
		return args -> {

			/*
			 * INSERT ALL THE NEEDED TEST DATA (will block)
			 */
			Data.initializeAllData(mongoTemplate);

			/*
			 * INITIALIZATION OF THE MATCH EVENT STREAM
			 */
			final MatchEventAgent matchEventAgent = new MatchEventAgent(mongoTemplate);
			final Flux<MatchEvent> matchEventStream = matchEventAgent.createAgentStream();
			// Subscribe and just let it run (forever)
			matchEventStream.subscribe();

			/*
			 * INITIALIZATION OF THE MATCH COMMENT STREAM
			 */
			final MatchCommentAgent matchCommentAgent = new MatchCommentAgent(mongoTemplate);
			final Flux<MatchComment> matchCommentStream = matchCommentAgent.createAgentStream();
			// Subscribe and just let it run (forever)
			matchCommentStream.subscribe();

		};
	}




	public static void main(String[] args) {
		SpringApplication.run(LightSkyUI.class, args);
	}

}
