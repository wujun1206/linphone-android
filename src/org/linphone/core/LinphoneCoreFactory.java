/*
LinphoneCoreFactory.java
Copyright (C) 2010  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package org.linphone.core;

import java.io.File;
import java.io.IOException;

public class LinphoneCoreFactory {
	static {
		System.loadLibrary("linphone");
	}
	static LinphoneCoreFactory theLinphoneCoreFactory = new LinphoneCoreFactory();
	
	public static LinphoneCoreFactory instance() {
	
		return theLinphoneCoreFactory;
	}
	public LinphoneAuthInfo createAuthInfo(String username,String password) {
		return new LinphoneAuthInfoImpl(username,password) ;
	}
	
	public LinphoneCore createLinphoneCore(LinphoneCoreListener listener, File userConfig,File factoryConfig,Object  userdata) throws IOException {
		return new LinphoneCoreImpl(listener,userConfig,factoryConfig,userdata);
	}
	


}