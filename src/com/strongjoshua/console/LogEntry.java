/**
 * Copyright 2015 StrongJoshua (strongjoshua@hotmail.com)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package com.strongjoshua.console;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.TimeUtils;
import com.strongjoshua.console.Console.LogLevel;

class LogEntry {
	private String text;
	private LogLevel level;
	private long timeStamp;
	
	protected LogEntry(String msg, LogLevel level) {
		this.text = msg;
		this.level = level;
		timeStamp = TimeUtils.millis();
	}

	public Color getColor() {
		return level.getColor();
	}
	
	protected String toConsoleString() {
		String r = "";
		if(level.equals(LogLevel.COMMAND))
			r += level.getIdentifier();
		r += text;
		return r;
	}
	
	@Override
	public String toString() {
		Date d = new Date(timeStamp);
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss z yyyy");
		return formatter.format(d) + ": " + level.getIdentifier() + text;
	}
}