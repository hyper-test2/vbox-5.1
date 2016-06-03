/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2015 Maxime Dor
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.vbox5_1.factory.event;

import io.kamax.hbox.event._Event;
import io.kamax.hboxd.event.machine.MachineDataChangeEvent;
import io.kamax.vbox5_1.factory._PreciseEventFactory;
import org.virtualbox_5_1.IEvent;
import org.virtualbox_5_1.IMachineDataChangedEvent;
import org.virtualbox_5_1.VBoxEventType;

public final class MachineDataChangeEventFactory implements _PreciseEventFactory {

    @Override
    public VBoxEventType getType() {
        return VBoxEventType.OnMachineDataChanged;
    }

    @Override
    public IMachineDataChangedEvent getRaw(IEvent vbEvent) {

        return IMachineDataChangedEvent.queryInterface(vbEvent);
    }

    @Override
    public _Event getEvent(IEvent vbEvent) {

        _Event ev = new MachineDataChangeEvent(getRaw(vbEvent).getMachineId());
        return ev;
    }

}
