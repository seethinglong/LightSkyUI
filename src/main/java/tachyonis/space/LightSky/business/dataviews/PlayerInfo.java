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
package tachyonis.space.LightSky.business.dataviews;


import tachyonis.space.LightSky.business.entities.Team;

public class PlayerInfo {

    private final String id;
    private final Team team;
    private final String name;


    public PlayerInfo(final String id, final Team team, final String name) {
        super();
        this.id = id;
        this.team = team;
        this.name = name;
    }


    public String getId() {
        return this.id;
    }

    public Team getTeam() {
        return this.team;
    }

    public String getTeamName() {
        return this.getTeam().getName();
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return "PlayerInfo{" +
                "id='" + this.id + '\'' +
                ", team=" + this.team +
                ", name='" + this.name + '\'' +
                '}';
    }

}
