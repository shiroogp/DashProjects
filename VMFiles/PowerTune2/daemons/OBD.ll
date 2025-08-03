source_filename = "test"
target datalayout = "e-p:32:32:32-f80:32:32"

%sockaddr = type { i32, [14 x i8] }
%in_addr = type { i32 }
%_IO_FILE = type { i32 }
%termios = type { i32, i32, i32, i32, i8, [1 x i8] }

@lr = internal unnamed_addr global i32 0
@0 = external local_unnamed_addr global i32
@1 = external local_unnamed_addr global i32
@global_var_15398.63 = constant [83 x i8] c"**********************************************************************************\00"
@global_var_153ec.65 = constant [83 x i8] c"*                            PowerTune UDP Daemon for                            *\00"
@global_var_15440.67 = constant [83 x i8] c"*                                  OBD2 ELM327                                   *\00"
@global_var_15494.69 = constant [83 x i8] c"*                                  Version 1.4                                   *\00"
@global_var_1553c.73 = constant [83 x i8] c"*                                                                                *\00"
@global_var_15590.75 = constant [83 x i8] c"*                    THIS SOFTWARE IS PROVIDED BY THE AUTHOR                     *\00"
@global_var_155e4.77 = constant [83 x i8] c"* ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,INCLUDING, BUT NOT LIMITED TO, *\00"
@global_var_15638.79 = constant [83 x i8] c"* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE *\00"
@global_var_1568c.81 = constant [83 x i8] c"* ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,         *\00"
@global_var_156e0.83 = constant [83 x i8] c"* INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES             *\00"
@global_var_15734.85 = constant [83 x i8] c"* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;   *\00"
@global_var_15788.87 = constant [83 x i8] c"* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND    *\00"
@global_var_157dc.89 = constant [83 x i8] c"* ON ANY THEORY OF LIABILITY,WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT      *\00"
@global_var_15830.91 = constant [83 x i8] c"* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS  *\00"
@global_var_15884.93 = constant [83 x i8] c"* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.                   *\00"
@global_var_158d8.95 = constant [83 x i8] c"*              Use of this software is strictly for PowerTune.                   *\00"
@global_var_1592c.97 = constant [83 x i8] c"* The distribution and sale of this Software is exclusive to the copyright       *\00"
@global_var_15980.99 = constant [83 x i8] c"*                        owner and his affilliates.                              *\00"
@global_var_159d4.101 = constant [83 x i8] c"*      To purchase a legal copy ,please email Markus.Ippy1981@gmail.com          *\00"
@global_var_15a30.105 = constant [5 x i8] c"eth0\00"
@global_var_15a38.108 = constant [3 x i8] c"r+\00"
@global_var_15a3c.110 = constant [12 x i8] c"Licence.lic\00"
@global_var_272e0.120 = local_unnamed_addr global i32 0
@global_var_274e8.126 = local_unnamed_addr global i32 0
@global_var_15ae8.128 = constant [7 x i8] c"socket\00"
@global_var_272d2.132 = local_unnamed_addr global i32 0
@global_var_15af0.136 = constant [10 x i8] c"127.0.0.1\00"
@global_var_15afc.140 = constant [20 x i8] c"inet_aton() failed\0A\00"
@global_var_15b10.142 = constant [8 x i8] c"OBD.cfg\00"
@global_var_15b1c.148 = constant [3 x i8] c"w+\00"
@global_var_15b20.150 = constant [12 x i8] c"OBDPIDS.txt\00"
@global_var_15b4c.156 = constant [5 x i8] c"ATZ\0D\00"
@global_var_15b54.158 = constant [7 x i8] c"ELM327\00"
@global_var_15b80.164 = constant [6 x i8] c"ATE0\0D\00"
@global_var_15b88.166 = constant [3 x i8] c"OK\00"
@global_var_15ba4.170 = constant [6 x i8] c"ATS0\0D\00"
@global_var_15bc8.174 = constant [5 x i8] c"ATI\0D\00"
@global_var_15bec.178 = constant [8 x i8] c"ATSP00\0D\00"
@global_var_15c08.182 = constant [6 x i8] c"ATDP\0D\00"
@global_var_15c10.184 = constant [5 x i8] c"AUTO\00"
@global_var_15c34.188 = constant [6 x i8] c"0100\0D\00"
@global_var_15c3c.190 = constant [3 x i8] c"41\00"
@global_var_15c40.192 = constant [7 x i8] c"%02hhX\00"
@global_var_15c68.196 = constant [7 x i8] c"0x%02X\00"
@global_var_15d38.212 = constant [6 x i8] c"0120\0D\00"
@global_var_15d5c.216 = constant [6 x i8] c"0140\0D\00"
@global_var_15d80.220 = constant [6 x i8] c"0160\0D\00"
@global_var_270c8.227 = local_unnamed_addr global i32 0
@global_var_15d88.232 = constant [7 x i8] c"01041\0D\00"
@global_var_15d90.236 = constant [6 x i8] c"46,%f\00"
@global_var_15d98.238 = constant [7 x i8] c"01051\0D\00"
@global_var_15da0.240 = constant [7 x i8] c"221,%d\00"
@global_var_15da8.242 = constant [7 x i8] c"01061\0D\00"
@global_var_15db0.246 = constant [7 x i8] c"104,%f\00"
@global_var_15db8.248 = constant [7 x i8] c"01071\0D\00"
@global_var_15dc0.250 = constant [7 x i8] c"102,%f\00"
@global_var_15dc8.252 = constant [7 x i8] c"01081\0D\00"
@global_var_15dd0.254 = constant [7 x i8] c"105,%f\00"
@global_var_15dd8.256 = constant [7 x i8] c"01091\0D\00"
@global_var_15de0.260 = constant [7 x i8] c"103,%f\00"
@global_var_15de8.263 = constant [7 x i8] c"010A1\0D\00"
@global_var_15df0.266 = constant [7 x i8] c"100,%d\00"
@global_var_15df8.268 = constant [7 x i8] c"010B1\0D\00"
@global_var_15e00.272 = constant [7 x i8] c"155,%d\00"
@global_var_15e08.274 = constant [6 x i8] c"22,%f\00"
@global_var_15e10.276 = constant [7 x i8] c"010C1\0D\00"
@global_var_15e18.278 = constant [7 x i8] c"179,%d\00"
@global_var_15e20.280 = constant [7 x i8] c"010D1\0D\00"
@global_var_15e28.282 = constant [7 x i8] c"199,%d\00"
@global_var_15e30.284 = constant [7 x i8] c"010E1\0D\00"
@global_var_15e38.286 = constant [7 x i8] c"121,%f\00"
@global_var_15e40.288 = constant [7 x i8] c"010F1\0D\00"
@global_var_15e48.290 = constant [7 x i8] c"135,%d\00"
@global_var_15e50.292 = constant [7 x i8] c"01101\0D\00"
@global_var_15e58.295 = constant [7 x i8] c"154,%d\00"
@global_var_15e60.297 = constant [7 x i8] c"01111\0D\00"
@global_var_15e68.300 = constant [7 x i8] c"210,%f\00"
@global_var_15e70.303 = constant [7 x i8] c"01121\0D\00"
@global_var_15e78.306 = constant [7 x i8] c"01131\0D\00"
@global_var_15e80.308 = constant [7 x i8] c"01141\0D\00"
@global_var_15e88.310 = constant [7 x i8] c"01151\0D\00"
@global_var_15e90.312 = constant [7 x i8] c"01161\0D\00"
@global_var_15e98.314 = constant [7 x i8] c"01171\0D\00"
@global_var_15ea0.316 = constant [7 x i8] c"01181\0D\00"
@global_var_15ea8.318 = constant [7 x i8] c"01191\0D\00"
@global_var_15eb0.320 = constant [7 x i8] c"011A1\0D\00"
@global_var_15eb8.322 = constant [7 x i8] c"011B1\0D\00"
@global_var_15ec0.324 = constant [7 x i8] c"011C1\0D\00"
@global_var_15ec8.326 = constant [7 x i8] c"011D1\0D\00"
@global_var_15ed0.328 = constant [7 x i8] c"011F1\0D\00"
@global_var_15ed8.330 = constant [7 x i8] c"015C1\0D\00"
@global_var_15ee0.332 = constant [6 x i8] c"31,%d\00"
@global_var_15ee8.334 = constant [7 x i8] c"01341\0D\00"
@global_var_15ef0.337 = constant [7 x i8] c"142,%f\00"
@global_var_15ef8.340 = constant [7 x i8] c"01351\0D\00"
@global_var_15f00.343 = constant [7 x i8] c"143,%f\00"
@global_var_15f08.345 = constant [7 x i8] c"01361\0D\00"
@global_var_15f10.347 = constant [7 x i8] c"144,%f\00"
@global_var_15f18.349 = constant [7 x i8] c"01371\0D\00"
@global_var_15f20.352 = constant [7 x i8] c"145,%f\00"
@global_var_15f28.355 = constant [7 x i8] c"01461\0D\00"
@global_var_15f30.358 = constant [5 x i8] c"9,%d\00"
@global_var_15f38.360 = constant [7 x i8] c"013C1\0D\00"
@global_var_15f40.364 = constant [7 x i8] c"277,%f\00"
@global_var_15f48.366 = constant [12 x i8] c"sending %s\0A\00"
@global_var_270a8.369 = local_unnamed_addr global i32 16
@global_var_15f6c.374 = constant [9 x i8] c"sendto()\00"
@2 = external global i32
@3 = internal constant [8 x i8] c"\1B[1;36m\00"
@global_var_15390.61 = constant i8* getelementptr inbounds ([8 x i8], [8 x i8]* @3, i32 0, i32 0)
@4 = internal constant [84 x i8] c"*                              \C2\A9 2018 Markus Ippy                                *\00"
@global_var_154e8.71 = constant i8* getelementptr inbounds ([84 x i8], [84 x i8]* @4, i32 0, i32 0)
@5 = internal constant [5 x i8] c"\1B[0m\00"
@global_var_15a28.103 = constant i8* getelementptr inbounds ([5 x i8], [5 x i8]* @5, i32 0, i32 0)
@6 = internal constant [2 x i8] c"-\00"
@7 = constant i8* getelementptr inbounds ([2 x i8], [2 x i8]* @6, i32 0, i32 0)
@8 = internal constant [28 x i8] c"\1B[32mLicence Key validated \00"
@global_var_15a4c.114 = constant i8* getelementptr inbounds ([28 x i8], [28 x i8]* @8, i32 0, i32 0)
@9 = internal constant [25 x i8] c"\1B[31mLicence Key Invalid\00"
@global_var_15a68.116 = constant i8* getelementptr inbounds ([25 x i8], [25 x i8]* @9, i32 0, i32 0)
@10 = internal constant [30 x i8] c"\1B[31mUsage: %s <Serial Port>\0A\00"
@global_var_15a84.118 = constant i8* getelementptr inbounds ([30 x i8], [30 x i8]* @10, i32 0, i32 0)
@11 = internal constant [30 x i8] c"\1B[31mSerial Port Open Failure\00"
@global_var_15aa4.122 = constant i8* getelementptr inbounds ([30 x i8], [30 x i8]* @11, i32 0, i32 0)
@12 = internal constant [34 x i8] c"\1B[32mSerial Port Open Succesfully\00"
@global_var_15ac4.124 = constant i8* getelementptr inbounds ([34 x i8], [34 x i8]* @12, i32 0, i32 0)
@global_var_272d0.130 = global %sockaddr* null
@global_var_272d4.134 = global %in_addr* null
@global_var_270b0.138 = local_unnamed_addr global %_IO_FILE* null
@global_var_270bc.144 = local_unnamed_addr global %_IO_FILE* null
@13 = internal constant [2 x i8] c",\00"
@14 = constant i8* getelementptr inbounds ([2 x i8], [2 x i8]* @13, i32 0, i32 0)
@global_var_270b8.152 = local_unnamed_addr global %_IO_FILE* null
@15 = internal constant [32 x i8] c"\1B[33mReset OBD ELM327 Interface\00"
@global_var_15b2c.154 = constant i8* getelementptr inbounds ([32 x i8], [32 x i8]* @15, i32 0, i32 0)
@16 = internal constant [9 x i8] c"\1B[32m%s\0A\00"
@global_var_15b5c.160 = constant i8* getelementptr inbounds ([9 x i8], [9 x i8]* @16, i32 0, i32 0)
@17 = internal constant [22 x i8] c"\1B[33mRequest echo off\00"
@global_var_15b68.162 = constant i8* getelementptr inbounds ([22 x i8], [22 x i8]* @17, i32 0, i32 0)
@18 = internal constant [24 x i8] c"\1B[33mRequest Spaces OFF\00"
@global_var_15b8c.168 = constant i8* getelementptr inbounds ([24 x i8], [24 x i8]* @18, i32 0, i32 0)
@19 = internal constant [25 x i8] c"\1B[33mRequest Device Name\00"
@global_var_15bac.172 = constant i8* getelementptr inbounds ([25 x i8], [25 x i8]* @19, i32 0, i32 0)
@20 = internal constant [25 x i8] c"\1B[33mAutodetect Protocol\00"
@global_var_15bd0.176 = constant i8* getelementptr inbounds ([25 x i8], [25 x i8]* @20, i32 0, i32 0)
@21 = internal constant [20 x i8] c"\1B[33mProtocol name \00"
@global_var_15bf4.180 = constant i8* getelementptr inbounds ([20 x i8], [20 x i8]* @21, i32 0, i32 0)
@22 = internal constant [26 x i8] c"\1B[33mSupported PIDS 0-20 \00"
@global_var_15c18.186 = constant i8* getelementptr inbounds ([26 x i8], [26 x i8]* @22, i32 0, i32 0)
@23 = internal constant [32 x i8] c"\1B[33mParsing Byte 1 0x%02X ...\0A\00"
@global_var_15c48.194 = constant i8* getelementptr inbounds ([32 x i8], [32 x i8]* @23, i32 0, i32 0)
@24 = internal constant [42 x i8] c"\1B[37mPID 0x%02X supported by your Vehicle\00"
@global_var_15c70.198 = constant i8* getelementptr inbounds ([42 x i8], [42 x i8]* @24, i32 0, i32 0)
@25 = internal constant [17 x i8] c"\1B[37mposition %d\00"
@global_var_15c9c.200 = constant i8* getelementptr inbounds ([17 x i8], [17 x i8]* @25, i32 0, i32 0)
@26 = internal constant [10 x i8] c"\1B[32m%d \0A\00"
@global_var_15cb0.202 = constant i8* getelementptr inbounds ([10 x i8], [10 x i8]* @26, i32 0, i32 0)
@27 = internal constant [32 x i8] c"\1B[33mParsing Byte 2 0x%02X ...\0A\00"
@global_var_15cbc.204 = constant i8* getelementptr inbounds ([32 x i8], [32 x i8]* @27, i32 0, i32 0)
@28 = internal constant [32 x i8] c"\1B[33mParsing Byte 3 0x%02X ...\0A\00"
@global_var_15cdc.206 = constant i8* getelementptr inbounds ([32 x i8], [32 x i8]* @28, i32 0, i32 0)
@29 = internal constant [32 x i8] c"\1B[33mParsing Byte 4 0x%02X ...\0A\00"
@global_var_15cfc.208 = constant i8* getelementptr inbounds ([32 x i8], [32 x i8]* @29, i32 0, i32 0)
@30 = internal constant [27 x i8] c"\1B[33mSupported PIDS 21-40 \00"
@global_var_15d1c.210 = constant i8* getelementptr inbounds ([27 x i8], [27 x i8]* @30, i32 0, i32 0)
@31 = internal constant [27 x i8] c"\1B[33mSupported PIDS 41-60 \00"
@global_var_15d40.214 = constant i8* getelementptr inbounds ([27 x i8], [27 x i8]* @31, i32 0, i32 0)
@32 = internal constant [27 x i8] c"\1B[33mSupported PIDS 61-80 \00"
@global_var_15d64.218 = constant i8* getelementptr inbounds ([27 x i8], [27 x i8]* @32, i32 0, i32 0)
@global_var_272cc.229 = external local_unnamed_addr global i8*
@33 = internal constant [23 x i8] c"\1B[31mUDP send pkt fail\00"
@global_var_15f54.372 = constant i8* getelementptr inbounds ([23 x i8], [23 x i8]* @33, i32 0, i32 0)
@global_var_15a48.112 = constant [2 x i8] c"-\00"
@global_var_15b18.146 = constant [2 x i8] c",\00"

define i32 @die(i8* %arg1) local_unnamed_addr {
dec_label_pc_10af0:
  call void @perror(i8* %arg1)
  call void @exit(i32 1)
  ret i32 ptrtoint (i32* @2 to i32)
}

define i32 @main(i32 %argc, i8** %argv) local_unnamed_addr {
dec_label_pc_10b10:
  %apsr_nzcv.global-to-local = alloca i32, align 4
  %cpsr_c.global-to-local = alloca i1, align 1
  %cpsr_z.global-to-local = alloca i1, align 1
  %fp.global-to-local = alloca i32, align 4
  %fpscr.global-to-local = alloca i32, align 4
  %r0.global-to-local = alloca i32, align 4
  %r1.global-to-local = alloca i32, align 4
  %r4.global-to-local = alloca i32, align 4
  %r5.global-to-local = alloca i32, align 4
  %tmp1871 = ptrtoint i8** %argv to i32
  store i32 %tmp1871, i32* %r1.global-to-local, align 4
  store i32 %argc, i32* %r0.global-to-local, align 4
  %tmp1875 = call i32 @__decompiler_undefined_function_0()
  %tmp1876 = call i32 @__decompiler_undefined_function_0()
  %tmp1877 = call i32 @__decompiler_undefined_function_0()
  %tmp1878 = call i32 @__decompiler_undefined_function_0()
  %stack_var_-2056 = alloca i32, align 4
  %tmp1880 = call i32 @__decompiler_undefined_function_0()
  %tmp1881 = call i32 @__decompiler_undefined_function_0()
  %stack_var_-2120 = alloca i32, align 4
  %tmp1886 = call i32 @__decompiler_undefined_function_0()
  %stack_var_-486 = alloca i32, align 4
  %stack_var_-488 = alloca i32, align 4
  %stack_var_-490 = alloca i32, align 4
  %stack_var_-492 = alloca i32, align 4
  %stack_var_-474 = alloca i32, align 4
  %stack_var_-476 = alloca i32, align 4
  %stack_var_-478 = alloca i32, align 4
  %stack_var_-480 = alloca i32, align 4
  %stack_var_-456 = alloca i32, align 4
  %stack_var_-496 = alloca i32, align 4
  %stack_var_-596 = alloca i32, align 4
  %stack_var_-2360 = alloca i32, align 4
  %stack_var_-2460 = alloca i32, align 4
  %tmp1982 = call i8 @__decompiler_undefined_function_9()
  %tmp1983 = call i8 @__decompiler_undefined_function_9()
  %tmp1984 = call i8 @__decompiler_undefined_function_9()
  %tmp1985 = call i8 @__decompiler_undefined_function_9()
  %tmp1986 = call i8 @__decompiler_undefined_function_9()
  %tmp1987 = call i8 @__decompiler_undefined_function_9()
  %tmp1988 = call i8 @__decompiler_undefined_function_9()
  %tmp1989 = call i8 @__decompiler_undefined_function_9()
  %tmp1990 = call i8 @__decompiler_undefined_function_9()
  %tmp1991 = call i8 @__decompiler_undefined_function_9()
  %stack_var_-2252 = alloca i32, align 4
  %tmp1993 = call i32 @__decompiler_undefined_function_0()
  %stack_var_-2356 = alloca i32, align 4
  %stack_var_-2352 = alloca i32, align 4
  %tmp2001 = call i32 @__decompiler_undefined_function_0()
  %stack_var_-2152 = alloca i32, align 4
  %stack_var_-600 = alloca i8, align 1
  %stack_var_-599 = alloca i8, align 1
  %stack_var_-598 = alloca i8, align 1
  %stack_var_-597 = alloca i8, align 1
  %stack_var_-4 = alloca i32, align 4
  %stack_var_-16 = alloca i32, align 4
  %v3_10b10 = load i32, i32* %r4.global-to-local, align 4
  store i32 %v3_10b10, i32* %stack_var_-16, align 4
  %v6_10b10 = load i32, i32* %r5.global-to-local, align 4
  %v9_10b10 = load i32, i32* %fp.global-to-local, align 4
  %v12_10b10 = load i32, i32* @lr, align 4
  store i32 %v12_10b10, i32* %stack_var_-4, align 4
  %v13_10b10 = ptrtoint i32* %stack_var_-16 to i32
  %v2_10b14 = ptrtoint i32* %stack_var_-4 to i32
  store i32 %v2_10b14, i32* %fp.global-to-local, align 4
  %v0_10b1c = load i32, i32* %r0.global-to-local, align 4
  %v0_10b20 = load i32, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15390.61 to i32), i32* %r0.global-to-local, align 4
  %v3_10b28 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15390.61 to i8*))
  store i32 ptrtoint ([83 x i8]* @global_var_15398.63 to i32), i32* %r0.global-to-local, align 4
  %v3_10b30 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15398.63, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_153ec.65 to i32), i32* %r0.global-to-local, align 4
  %v3_10b38 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_153ec.65, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15440.67 to i32), i32* %r0.global-to-local, align 4
  %v3_10b40 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15440.67, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15494.69 to i32), i32* %r0.global-to-local, align 4
  %v3_10b48 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15494.69, i32 0, i32 0))
  store i32 ptrtoint (i8** @global_var_154e8.71 to i32), i32* %r0.global-to-local, align 4
  %v3_10b50 = call i32 @puts(i8* bitcast (i8** @global_var_154e8.71 to i8*))
  store i32 ptrtoint ([83 x i8]* @global_var_1553c.73 to i32), i32* %r0.global-to-local, align 4
  %v3_10b58 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_1553c.73, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15590.75 to i32), i32* %r0.global-to-local, align 4
  %v3_10b60 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15590.75, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_155e4.77 to i32), i32* %r0.global-to-local, align 4
  %v3_10b68 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_155e4.77, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15638.79 to i32), i32* %r0.global-to-local, align 4
  %v3_10b70 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15638.79, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_1568c.81 to i32), i32* %r0.global-to-local, align 4
  %v3_10b78 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_1568c.81, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_156e0.83 to i32), i32* %r0.global-to-local, align 4
  %v3_10b80 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_156e0.83, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15734.85 to i32), i32* %r0.global-to-local, align 4
  %v3_10b88 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15734.85, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15788.87 to i32), i32* %r0.global-to-local, align 4
  %v3_10b90 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15788.87, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_157dc.89 to i32), i32* %r0.global-to-local, align 4
  %v3_10b98 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_157dc.89, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15830.91 to i32), i32* %r0.global-to-local, align 4
  %v3_10ba0 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15830.91, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15884.93 to i32), i32* %r0.global-to-local, align 4
  %v3_10ba8 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15884.93, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_158d8.95 to i32), i32* %r0.global-to-local, align 4
  %v3_10bb0 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_158d8.95, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_1592c.97 to i32), i32* %r0.global-to-local, align 4
  %v3_10bb8 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_1592c.97, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15980.99 to i32), i32* %r0.global-to-local, align 4
  %v3_10bc0 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15980.99, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_159d4.101 to i32), i32* %r0.global-to-local, align 4
  %v3_10bc8 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_159d4.101, i32 0, i32 0))
  store i32 ptrtoint ([83 x i8]* @global_var_15398.63 to i32), i32* %r0.global-to-local, align 4
  %v3_10bd0 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_15398.63, i32 0, i32 0))
  store i32 ptrtoint (i8** @global_var_15a28.103 to i32), i32* %r0.global-to-local, align 4
  %v3_10bd8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15a28.103 to i8*))
  store i8 0, i8* %stack_var_-597, align 1
  store i8 0, i8* %stack_var_-598, align 1
  store i8 0, i8* %stack_var_-599, align 1
  store i8 0, i8* %stack_var_-600, align 1
  store i32 2, i32* %r1.global-to-local, align 4
  store i32 2, i32* %r0.global-to-local, align 4
  %v3_10c60 = call i32 @socket(i32 2, i32 2, i32 0)
  %v2_10c70 = ptrtoint i32* %stack_var_-2152 to i32
  store i32 ptrtoint ([5 x i8]* @global_var_15a30.105 to i32), i32* %r1.global-to-local, align 4
  %tmp2130 = bitcast i32* %stack_var_-2152 to i8*
  store i32 %v2_10c70, i32* %r0.global-to-local, align 4
  %v7_10c94 = call i8* @strncpy(i8* %tmp2130, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @global_var_15a30.105, i32 0, i32 0), i32 15)
  store i32 35111, i32* %r1.global-to-local, align 4
  store i32 %v3_10c60, i32* %r0.global-to-local, align 4
  %v2_10cb0 = call i32 (i32, i32, ...) @ioctl(i32 %v3_10c60, i32 35111)
  store i32 %v3_10c60, i32* %r0.global-to-local, align 4
  %v1_10cb8 = call i32 @close(i32 %v3_10c60)
  store i32 ptrtoint ([3 x i8]* @global_var_15a38.108 to i32), i32* %r1.global-to-local, align 4
  store i32 ptrtoint ([12 x i8]* @global_var_15a3c.110 to i32), i32* %r0.global-to-local, align 4
  %v5_10cd4 = call %_IO_FILE* @fopen(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @global_var_15a3c.110, i32 0, i32 0), i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15a38.108, i32 0, i32 0))
  %v7_10cd4 = ptrtoint %_IO_FILE* %v5_10cd4 to i32
  store i32 %v7_10cd4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10ce0 = icmp eq %_IO_FILE* %v5_10cd4, null
  store i1 %v7_10ce0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10ce0, label %dec_label_pc_10d98, label %dec_label_pc_10d74.preheader

dec_label_pc_10d74.preheader:                     ; preds = %dec_label_pc_10b10
  %v2_10d78 = ptrtoint i32* %stack_var_-2352 to i32
  %tmp2131 = bitcast i32* %stack_var_-2352 to i8*
  %v2_10d10 = ptrtoint i32* %stack_var_-2356 to i32
  %tmp2132 = bitcast i32* %stack_var_-2356 to i8**
  %v2_10d38 = ptrtoint i32* %stack_var_-2252 to i32
  br label %dec_label_pc_10d74.outer

dec_label_pc_10cec:                               ; preds = %dec_label_pc_10d74
  store i32 ptrtoint ([2 x i8]* @global_var_15a48.112 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_10d78, i32* %r0.global-to-local, align 4
  %v6_10cfc = call i8* @strtok(i8* %tmp2131, i8* getelementptr inbounds ([2 x i8], [2 x i8]* @global_var_15a48.112, i32 0, i32 0))
  %v8_10cfc276 = ptrtoint i8* %v6_10cfc to i32
  store i32 %v8_10cfc276, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10d6c278 = icmp eq i8* %v6_10cfc, null
  store i1 %v7_10d6c278, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10d6c278, label %dec_label_pc_10d74, label %dec_label_pc_10d08

dec_label_pc_10d08:                               ; preds = %dec_label_pc_10cec, %dec_label_pc_10d08
  %v8_10cfc281 = phi i32 [ %v8_10cfc, %dec_label_pc_10d08 ], [ %v8_10cfc276, %dec_label_pc_10cec ]
  %v6_10cfc.sink280 = phi i8* [ %v6_10d60, %dec_label_pc_10d08 ], [ %v6_10cfc, %dec_label_pc_10cec ]
  %stack_var_-56.0279 = phi i32 [ %v1_10d50, %dec_label_pc_10d08 ], [ %stack_var_-56.1.ph, %dec_label_pc_10cec ]
  store i32 %v2_10d10, i32* %r1.global-to-local, align 4
  store i32 %v8_10cfc281, i32* %r0.global-to-local, align 4
  %v7_10d20 = call i32 @strtoimax(i8* nonnull %v6_10cfc.sink280, i8** %tmp2132, i32 0)
  %v2_10d40 = add i32 %stack_var_-56.0279, %v2_10d38
  %v1_10d48 = trunc i32 %v7_10d20 to i8
  %v3_10d48 = inttoptr i32 %v2_10d40 to i8*
  store i8 %v1_10d48, i8* %v3_10d48, align 1
  %v1_10d50 = add i32 %stack_var_-56.0279, 1
  store i32 ptrtoint ([2 x i8]* @global_var_15a48.112 to i32), i32* %r1.global-to-local, align 4
  store i32 0, i32* %r0.global-to-local, align 4
  %v6_10d60 = call i8* @strtok(i8* null, i8* getelementptr inbounds ([2 x i8], [2 x i8]* @global_var_15a48.112, i32 0, i32 0))
  %v8_10cfc = ptrtoint i8* %v6_10d60 to i32
  store i32 %v8_10cfc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10d6c = icmp eq i8* %v6_10d60, null
  store i1 %v7_10d6c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10d6c, label %dec_label_pc_10d74.outer, label %dec_label_pc_10d08

dec_label_pc_10d74.outer:                         ; preds = %dec_label_pc_10d08, %dec_label_pc_10d74.preheader
  %stack_var_-56.1.ph = phi i32 [ 0, %dec_label_pc_10d74.preheader ], [ %v1_10d50, %dec_label_pc_10d08 ]
  br label %dec_label_pc_10d74

dec_label_pc_10d74:                               ; preds = %dec_label_pc_10d74.outer, %dec_label_pc_10cec
  store i32 100, i32* %r1.global-to-local, align 4
  store i32 %v2_10d78, i32* %r0.global-to-local, align 4
  %v7_10d88 = call i8* @fgets(i8* %tmp2131, i32 100, %_IO_FILE* nonnull %v5_10cd4)
  %v9_10d88 = ptrtoint i8* %v7_10d88 to i32
  store i32 %v9_10d88, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10d90 = icmp eq i8* %v7_10d88, null
  store i1 %v7_10d90, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10d90, label %dec_label_pc_10d98, label %dec_label_pc_10cec

dec_label_pc_10d98:                               ; preds = %dec_label_pc_10d74, %dec_label_pc_10b10
  store i32 %v7_10cd4, i32* %r0.global-to-local, align 4
  %v3_10d9c = call i32 @fclose(%_IO_FILE* %v5_10cd4)
  store i32 %v3_10d9c, i32* %r0.global-to-local, align 4
  %v3_10da8 = icmp ult i8 %tmp1991, %tmp1990
  %v4_10da8 = icmp ne i1 %v3_10da8, true
  store i1 %v4_10da8, i1* %cpsr_c.global-to-local, align 1
  %v10_10da8 = icmp eq i8 %tmp1991, %tmp1990
  store i1 %v10_10da8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v10_10da8, label %dec_label_pc_10db0, label %dec_label_pc_10e18

dec_label_pc_10db0:                               ; preds = %dec_label_pc_10d98
  %v3_10db8 = icmp ult i8 %tmp1989, %tmp1988
  %v4_10db8 = icmp ne i1 %v3_10db8, true
  store i1 %v4_10db8, i1* %cpsr_c.global-to-local, align 1
  %v10_10db8 = icmp eq i8 %tmp1989, %tmp1988
  store i1 %v10_10db8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v10_10db8, label %dec_label_pc_10dc0, label %dec_label_pc_10e18

dec_label_pc_10dc0:                               ; preds = %dec_label_pc_10db0
  %v4_10dc0 = zext i8 %tmp1987 to i32
  %v4_10dc4 = urem i32 %tmp2001, 256
  %v3_10dc8 = icmp ult i32 %v4_10dc0, %v4_10dc4
  %v4_10dc8 = icmp ne i1 %v3_10dc8, true
  store i1 %v4_10dc8, i1* %cpsr_c.global-to-local, align 1
  %v10_10dc8 = icmp eq i32 %v4_10dc0, %v4_10dc4
  store i1 %v10_10dc8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v10_10dc8, label %dec_label_pc_10dd0, label %dec_label_pc_10e18

dec_label_pc_10dd0:                               ; preds = %dec_label_pc_10dc0
  %v3_10dd8 = icmp ult i8 %tmp1986, %tmp1985
  %v4_10dd8 = icmp ne i1 %v3_10dd8, true
  store i1 %v4_10dd8, i1* %cpsr_c.global-to-local, align 1
  %v10_10dd8 = icmp eq i8 %tmp1986, %tmp1985
  store i1 %v10_10dd8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v10_10dd8, label %dec_label_pc_10de0, label %dec_label_pc_10e18

dec_label_pc_10de0:                               ; preds = %dec_label_pc_10dd0
  %v3_10de8 = icmp ult i8 %tmp1984, %tmp1983
  %v4_10de8 = icmp ne i1 %v3_10de8, true
  store i1 %v4_10de8, i1* %cpsr_c.global-to-local, align 1
  %v10_10de8 = icmp eq i8 %tmp1984, %tmp1983
  store i1 %v10_10de8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v10_10de8, label %dec_label_pc_10df0, label %dec_label_pc_10e18

dec_label_pc_10df0:                               ; preds = %dec_label_pc_10de0
  %v4_10df0 = urem i32 %tmp1993, 256
  %v4_10df4 = zext i8 %tmp1982 to i32
  %v3_10df8 = icmp ult i32 %v4_10df0, %v4_10df4
  %v4_10df8 = icmp ne i1 %v3_10df8, true
  store i1 %v4_10df8, i1* %cpsr_c.global-to-local, align 1
  %v10_10df8 = icmp eq i32 %v4_10df0, %v4_10df4
  store i1 %v10_10df8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v10_10df8, label %dec_label_pc_10e00, label %dec_label_pc_10e18

dec_label_pc_10e00:                               ; preds = %dec_label_pc_10df0
  store i32 ptrtoint (i8** @global_var_15a4c.114 to i32), i32* %r0.global-to-local, align 4
  %v3_10e04 = call i32 @puts(i8* bitcast (i8** @global_var_15a4c.114 to i8*))
  store i32 %v3_10e04, i32* %r0.global-to-local, align 4
  %v2_10e0c = icmp ult i32 %v0_10b1c, 2
  %v3_10e0c = icmp ne i1 %v2_10e0c, true
  store i1 %v3_10e0c, i1* %cpsr_c.global-to-local, align 1
  %v9_10e0c = icmp eq i32 %v0_10b1c, 2
  store i1 %v9_10e0c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_10e0c, label %dec_label_pc_10e44, label %dec_label_pc_10e28

dec_label_pc_10e18:                               ; preds = %dec_label_pc_10df0, %dec_label_pc_10de0, %dec_label_pc_10dd0, %dec_label_pc_10dc0, %dec_label_pc_10db0, %dec_label_pc_10d98
  store i32 ptrtoint (i8** @global_var_15a68.116 to i32), i32* %r0.global-to-local, align 4
  %v3_10e1c = call i32 @puts(i8* bitcast (i8** @global_var_15a68.116 to i8*))
  store i32 1, i32* %r0.global-to-local, align 4
  call void @exit(i32 1)
  unreachable

dec_label_pc_10e28:                               ; preds = %dec_label_pc_10e00
  store i32 ptrtoint (i8** @global_var_15a84.118 to i32), i32* %r0.global-to-local, align 4
  %v3_10e38 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15a84.118 to i8*))
  store i32 1, i32* %r0.global-to-local, align 4
  call void @exit(i32 1)
  unreachable

dec_label_pc_10e44:                               ; preds = %dec_label_pc_10e00
  %v1_10e48 = add i32 %v0_10b20, 4
  %v1_10e4c = inttoptr i32 %v1_10e48 to i32*
  %v2_10e4c = load i32, i32* %v1_10e4c, align 4
  store i32 %v2_10e4c, i32* %r0.global-to-local, align 4
  %v1_10e54 = call i32 @SerialConnection(i32 %v2_10e4c)
  store i32 %v1_10e54, i32* %r0.global-to-local, align 4
  store i32 %v1_10e54, i32* @global_var_272e0.120, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10e6c = icmp eq i32 %v1_10e54, 0
  store i1 %v7_10e6c, i1* %cpsr_z.global-to-local, align 1
  %v8_10e70 = icmp sgt i32 %v1_10e54, 0
  br i1 %v8_10e70, label %dec_label_pc_10e84, label %dec_label_pc_10e74

dec_label_pc_10e74:                               ; preds = %dec_label_pc_10e44
  store i32 ptrtoint (i8** @global_var_15aa4.122 to i32), i32* %r0.global-to-local, align 4
  %v3_10e78 = call i32 @puts(i8* bitcast (i8** @global_var_15aa4.122 to i8*))
  store i32 1, i32* %r0.global-to-local, align 4
  call void @exit(i32 1)
  unreachable

dec_label_pc_10e84:                               ; preds = %dec_label_pc_10e44
  store i32 ptrtoint (i8** @global_var_15ac4.124 to i32), i32* %r0.global-to-local, align 4
  %v3_10e88 = call i32 @puts(i8* bitcast (i8** @global_var_15ac4.124 to i8*))
  store i32 2, i32* %r1.global-to-local, align 4
  store i32 2, i32* %r0.global-to-local, align 4
  %v3_10e98 = call i32 @socket(i32 2, i32 2, i32 17)
  store i32 %v3_10e98, i32* %r0.global-to-local, align 4
  store i32 %v3_10e98, i32* @global_var_274e8.126, align 4
  %v2_10eb0 = icmp eq i32 %v3_10e98, -1
  store i1 %v2_10eb0, i1* %cpsr_c.global-to-local, align 1
  store i1 %v2_10eb0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v2_10eb0, label %dec_label_pc_10eb8, label %dec_label_pc_10ec0

dec_label_pc_10eb8:                               ; preds = %dec_label_pc_10e84
  store i32 ptrtoint ([7 x i8]* @global_var_15ae8.128 to i32), i32* %r0.global-to-local, align 4
  %v3_10ebc = call i32 @die(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15ae8.128, i32 0, i32 0))
  unreachable

dec_label_pc_10ec0:                               ; preds = %dec_label_pc_10e84
  store i32 0, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (%sockaddr** @global_var_272d0.130 to i32), i32* %r0.global-to-local, align 4
  %v5_10ecc = call i32* @memset(i32* bitcast (%sockaddr** @global_var_272d0.130 to i32*), i32 0, i32 16)
  store i16 2, i16* bitcast (%sockaddr** @global_var_272d0.130 to i16*), align 4
  store i32 -20082, i32* %r0.global-to-local, align 4
  %v3_10ee0 = call i16 @htons(i16 -20082)
  store i16 %v3_10ee0, i16* bitcast (i32* @global_var_272d2.132 to i16*), align 4
  store i32 ptrtoint (%in_addr** @global_var_272d4.134 to i32), i32* %r1.global-to-local, align 4
  store i32 ptrtoint ([10 x i8]* @global_var_15af0.136 to i32), i32* %r0.global-to-local, align 4
  %v6_10efc = call i32 @inet_aton(i8* getelementptr inbounds ([10 x i8], [10 x i8]* @global_var_15af0.136, i32 0, i32 0), %in_addr* bitcast (%in_addr** @global_var_272d4.134 to %in_addr*))
  store i32 %v6_10efc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10f04 = icmp eq i32 %v6_10efc, 0
  store i1 %v7_10f04, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10f04, label %dec_label_pc_10f0c, label %dec_label_pc_10f2c

dec_label_pc_10f0c:                               ; preds = %dec_label_pc_10ec0
  %v2_10f10 = load %_IO_FILE*, %_IO_FILE** @global_var_270b0.138, align 4
  store i32 1, i32* %r1.global-to-local, align 4
  store i32 ptrtoint ([20 x i8]* @global_var_15afc.140 to i32), i32* %r0.global-to-local, align 4
  %v7_10f20 = call i32 @fwrite(i32* bitcast ([20 x i8]* @global_var_15afc.140 to i32*), i32 1, i32 19, %_IO_FILE* %v2_10f10)
  store i32 1, i32* %r0.global-to-local, align 4
  call void @exit(i32 1)
  unreachable

dec_label_pc_10f2c:                               ; preds = %dec_label_pc_10ec0
  store i32 ptrtoint ([3 x i8]* @global_var_15a38.108 to i32), i32* %r1.global-to-local, align 4
  store i32 ptrtoint ([8 x i8]* @global_var_15b10.142 to i32), i32* %r0.global-to-local, align 4
  %v6_10f34 = call %_IO_FILE* @fopen(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @global_var_15b10.142, i32 0, i32 0), i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15a38.108, i32 0, i32 0))
  %v8_10f34 = ptrtoint %_IO_FILE* %v6_10f34 to i32
  store i32 %v8_10f34, i32* %r0.global-to-local, align 4
  store i32 %v8_10f34, i32* bitcast (%_IO_FILE** @global_var_270bc.144 to i32*), align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10f4c = icmp eq %_IO_FILE* %v6_10f34, null
  store i1 %v7_10f4c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10f4c, label %dec_label_pc_11018, label %dec_label_pc_10fdc.preheader

dec_label_pc_10fdc.preheader:                     ; preds = %dec_label_pc_10f2c
  %v2_10fec = ptrtoint i32* %stack_var_-2460 to i32
  %tmp2135 = bitcast i32* %stack_var_-2460 to i8*
  %v2_10f80 = ptrtoint i32* %stack_var_-2360 to i32
  %tmp2136 = bitcast i32* %stack_var_-2360 to i8**
  %v2_10fa0 = ptrtoint i32* %stack_var_-596 to i32
  store i32 100, i32* %r1.global-to-local, align 4
  store i32 %v2_10fec, i32* %r0.global-to-local, align 4
  %v7_10ff82206 = call i8* @fgets(i8* %tmp2135, i32 100, %_IO_FILE* nonnull %v6_10f34)
  %v9_10ff82207 = ptrtoint i8* %v7_10ff82206 to i32
  store i32 %v9_10ff82207, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_110002208 = icmp eq i8* %v7_10ff82206, null
  store i1 %v7_110002208, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_110002208, label %dec_label_pc_11008, label %dec_label_pc_10f58

dec_label_pc_10f58:                               ; preds = %dec_label_pc_10fdc.preheader, %dec_label_pc_10fdc.loopexit
  %stack_var_-52.12209 = phi i32 [ %stack_var_-52.0.lcssa, %dec_label_pc_10fdc.loopexit ], [ 0, %dec_label_pc_10fdc.preheader ]
  store i32 ptrtoint ([2 x i8]* @global_var_15b18.146 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_10fec, i32* %r0.global-to-local, align 4
  %v6_10f6c = call i8* @strtok(i8* %tmp2135, i8* getelementptr inbounds ([2 x i8], [2 x i8]* @global_var_15b18.146, i32 0, i32 0))
  %v8_10f6c270 = ptrtoint i8* %v6_10f6c to i32
  store i32 %v8_10f6c270, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10fd4272 = icmp eq i8* %v6_10f6c, null
  store i1 %v7_10fd4272, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10fd4272, label %dec_label_pc_10fdc.loopexit, label %dec_label_pc_10f78

dec_label_pc_10f78:                               ; preds = %dec_label_pc_10f58, %dec_label_pc_10f78
  %v8_10f6c275 = phi i32 [ %v8_10f6c, %dec_label_pc_10f78 ], [ %v8_10f6c270, %dec_label_pc_10f58 ]
  %v6_10f6c.sink274 = phi i8* [ %v6_10fc8, %dec_label_pc_10f78 ], [ %v6_10f6c, %dec_label_pc_10f58 ]
  %stack_var_-52.0273 = phi i32 [ %v1_10fb8, %dec_label_pc_10f78 ], [ %stack_var_-52.12209, %dec_label_pc_10f58 ]
  store i32 %v2_10f80, i32* %r1.global-to-local, align 4
  store i32 %v8_10f6c275, i32* %r0.global-to-local, align 4
  %v7_10f90 = call i32 @strtoimax(i8* nonnull %v6_10f6c.sink274, i8** %tmp2136, i32 0)
  %v2_10fa8 = add i32 %stack_var_-52.0273, %v2_10fa0
  %v1_10fb0 = trunc i32 %v7_10f90 to i8
  %v3_10fb0 = inttoptr i32 %v2_10fa8 to i8*
  store i8 %v1_10fb0, i8* %v3_10fb0, align 1
  %v1_10fb8 = add i32 %stack_var_-52.0273, 1
  store i32 ptrtoint ([2 x i8]* @global_var_15b18.146 to i32), i32* %r1.global-to-local, align 4
  store i32 0, i32* %r0.global-to-local, align 4
  %v6_10fc8 = call i8* @strtok(i8* null, i8* getelementptr inbounds ([2 x i8], [2 x i8]* @global_var_15b18.146, i32 0, i32 0))
  %v8_10f6c = ptrtoint i8* %v6_10fc8 to i32
  store i32 %v8_10f6c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_10fd4 = icmp eq i8* %v6_10fc8, null
  store i1 %v7_10fd4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_10fd4, label %dec_label_pc_10fdc.loopexit, label %dec_label_pc_10f78

dec_label_pc_10fdc.loopexit:                      ; preds = %dec_label_pc_10f78, %dec_label_pc_10f58
  %stack_var_-52.0.lcssa = phi i32 [ %stack_var_-52.12209, %dec_label_pc_10f58 ], [ %v1_10fb8, %dec_label_pc_10f78 ]
  %v2_10fe0.pre = load %_IO_FILE*, %_IO_FILE** @global_var_270bc.144, align 4
  store i32 100, i32* %r1.global-to-local, align 4
  store i32 %v2_10fec, i32* %r0.global-to-local, align 4
  %v7_10ff8 = call i8* @fgets(i8* %tmp2135, i32 100, %_IO_FILE* %v2_10fe0.pre)
  %v9_10ff8 = ptrtoint i8* %v7_10ff8 to i32
  store i32 %v9_10ff8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11000 = icmp eq i8* %v7_10ff8, null
  store i1 %v7_11000, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_11000, label %dec_label_pc_11008, label %dec_label_pc_10f58

dec_label_pc_11008:                               ; preds = %dec_label_pc_10fdc.loopexit, %dec_label_pc_10fdc.preheader
  %stack_var_-52.1.lcssa = phi i32 [ 0, %dec_label_pc_10fdc.preheader ], [ %stack_var_-52.0.lcssa, %dec_label_pc_10fdc.loopexit ]
  %v2_1100c = load %_IO_FILE*, %_IO_FILE** @global_var_270bc.144, align 4
  %v3_1100c = ptrtoint %_IO_FILE* %v2_1100c to i32
  store i32 %v3_1100c, i32* %r0.global-to-local, align 4
  %v3_11014 = call i32 @fclose(%_IO_FILE* %v2_1100c)
  store i32 %v3_11014, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11018

dec_label_pc_11018:                               ; preds = %dec_label_pc_11008, %dec_label_pc_10f2c
  %stack_var_-52.2 = phi i32 [ 0, %dec_label_pc_10f2c ], [ %stack_var_-52.1.lcssa, %dec_label_pc_11008 ]
  store i32 ptrtoint ([3 x i8]* @global_var_15b1c.148 to i32), i32* %r1.global-to-local, align 4
  store i32 ptrtoint ([12 x i8]* @global_var_15b20.150 to i32), i32* %r0.global-to-local, align 4
  %v6_11020 = call %_IO_FILE* @fopen(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @global_var_15b20.150, i32 0, i32 0), i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15b1c.148, i32 0, i32 0))
  %v8_11020 = ptrtoint %_IO_FILE* %v6_11020 to i32
  store i32 %v8_11020, i32* %r0.global-to-local, align 4
  store i32 %v8_11020, i32* bitcast (%_IO_FILE** @global_var_270b8.152 to i32*), align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 true, i1* %cpsr_z.global-to-local, align 1
  %v2_11034 = ptrtoint i32* %stack_var_-496 to i32
  %tmp2137 = bitcast i32* %stack_var_-496 to i8*
  %v2_11194 = ptrtoint i32* %stack_var_-456 to i32
  %v2_119cc = ptrtoint i32* %stack_var_-480 to i32
  %tmp2138 = bitcast i32* %stack_var_-480 to i8*
  %v2_119e8 = ptrtoint i32* %stack_var_-478 to i32
  %tmp2139 = bitcast i32* %stack_var_-478 to i8*
  %v2_11a04 = ptrtoint i32* %stack_var_-476 to i32
  %tmp2140 = bitcast i32* %stack_var_-476 to i8*
  %v2_11a20 = ptrtoint i32* %stack_var_-474 to i32
  %tmp2141 = bitcast i32* %stack_var_-474 to i8*
  %v2_11ff8 = ptrtoint i32* %stack_var_-492 to i32
  %tmp2142 = bitcast i32* %stack_var_-492 to i8*
  %v2_12014 = ptrtoint i32* %stack_var_-490 to i32
  %tmp2143 = bitcast i32* %stack_var_-490 to i8*
  %v2_12030 = ptrtoint i32* %stack_var_-488 to i32
  %tmp2144 = bitcast i32* %stack_var_-488 to i8*
  %v2_1204c = ptrtoint i32* %stack_var_-486 to i32
  %tmp2145 = bitcast i32* %stack_var_-486 to i8*
  %v2_12938 = add i32 %v2_11194, -1
  %v2_128d8 = add i32 %v13_10b10, -480
  br label %dec_label_pc_11034.outer

dec_label_pc_11034.outer:                         ; preds = %dec_label_pc_12d10.backedge.thread, %dec_label_pc_11018
  %stack_var_-24.7269.ph = phi i32 [ %stack_var_-24.7.be.ph, %dec_label_pc_12d10.backedge.thread ], [ 1, %dec_label_pc_11018 ]
  %stack_var_-40.33267.ph = phi i32 [ %stack_var_-40.33.be.ph, %dec_label_pc_12d10.backedge.thread ], [ 0, %dec_label_pc_11018 ]
  %stack_var_-44.17266.ph = phi i32 [ %stack_var_-44.17.be.ph, %dec_label_pc_12d10.backedge.thread ], [ 1, %dec_label_pc_11018 ]
  %v1_1104c = add i32 %stack_var_-24.7269.ph, -1
  %v9_11050 = icmp eq i32 %v1_1104c, 9
  %tmp2147 = and i32 %v1_1104c, 1073741824
  %v7_11054 = icmp ne i32 %tmp2147, 0
  br label %dec_label_pc_11034

dec_label_pc_11034:                               ; preds = %dec_label_pc_11034.outer, %dec_label_pc_12d10.backedge
  %stack_var_-44.17266 = phi i32 [ %stack_var_-44.16, %dec_label_pc_12d10.backedge ], [ %stack_var_-44.17266.ph, %dec_label_pc_11034.outer ]
  store i32 0, i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v4_11044 = call i32* @memset(i32* nonnull %stack_var_-496, i32 0, i32 40)
  %v6_11044 = ptrtoint i32* %v4_11044 to i32
  store i32 %v6_11044, i32* %r0.global-to-local, align 4
  store i1 %v9_11050, i1* %cpsr_z.global-to-local, align 1
  store i32 %v1_1104c, i32* @0, align 4
  store i1 %v7_11054, i1* %cpsr_c.global-to-local, align 1
  switch i32 %stack_var_-24.7269.ph, label %dec_label_pc_12d10.backedge.thread [
    i32 1, label %dec_label_pc_11084
    i32 2, label %dec_label_pc_111dc
    i32 3, label %dec_label_pc_11328
    i32 4, label %dec_label_pc_11474
    i32 5, label %dec_label_pc_115cc
    i32 6, label %dec_label_pc_11724
    i32 7, label %dec_label_pc_1187c
    i32 8, label %dec_label_pc_11ea8
    i32 9, label %dec_label_pc_1236c
    i32 10, label %dec_label_pc_1283c
  ]

dec_label_pc_11084:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15b2c.154 to i32), i32* %r0.global-to-local, align 4
  %v3_11088 = call i32 @puts(i8* bitcast (i8** @global_var_15b2c.154 to i8*))
  %v2_11090 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([5 x i8]* @global_var_15b4c.156 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11090, i32* %r0.global-to-local, align 4
  %v4_110a0 = call i32 @write(i32 %v2_11090, i32* bitcast ([5 x i8]* @global_var_15b4c.156 to i32*), i32 4)
  store i32 %v4_110a0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11188

dec_label_pc_110b0:                               ; preds = %dec_label_pc_11188
  %v2_110b8 = add i32 %v4_111b0, %v4_1119c
  %v4_110bc = inttoptr i32 %v2_110b8 to i8*
  %v1_110c4 = add i32 %v2_110b8, -1
  %v1_110c8 = inttoptr i32 %v1_110c4 to i8*
  %v2_110c8 = load i8, i8* %v1_110c8, align 1
  %v2_110cc = icmp ult i8 %v2_110c8, 62
  %v3_110cc = icmp ne i1 %v2_110cc, true
  store i1 %v3_110cc, i1* %cpsr_c.global-to-local, align 1
  %v9_110cc = icmp eq i8 %v2_110c8, 62
  store i1 %v9_110cc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_110cc, label %dec_label_pc_110d4, label %dec_label_pc_11188

dec_label_pc_110d4:                               ; preds = %dec_label_pc_110b0
  store i32 ptrtoint ([7 x i8]* @global_var_15b54.158 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_110e0 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15b54.158, i32 0, i32 0))
  %v8_110e0 = ptrtoint i8* %v6_110e0 to i32
  store i32 %v8_110e0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_110e8 = icmp eq i8* %v6_110e0, null
  store i1 %v7_110e8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_110e8, label %dec_label_pc_111cc, label %dec_label_pc_11150.preheader

dec_label_pc_11150.preheader:                     ; preds = %dec_label_pc_110d4
  %v2_1115c257 = load i8, i8* %tmp2137, align 4
  %v2_11160259 = icmp ult i8 %v2_1115c257, 16
  %v3_11160260 = icmp ne i1 %v2_11160259, true
  store i1 %v3_11160260, i1* %cpsr_c.global-to-local, align 1
  %v9_11160261 = icmp eq i8 %v2_1115c257, 16
  store i1 %v9_11160261, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11160261, label %dec_label_pc_11168, label %dec_label_pc_11104

dec_label_pc_11104:                               ; preds = %dec_label_pc_11150.preheader, %dec_label_pc_11144.dec_label_pc_11104_crit_edge
  %v2_11110 = phi i8 [ %v2_11110.pre, %dec_label_pc_11144.dec_label_pc_11104_crit_edge ], [ %v2_1115c257, %dec_label_pc_11150.preheader ]
  %v1_1115c265 = phi i8* [ %v1_1115c, %dec_label_pc_11144.dec_label_pc_11104_crit_edge ], [ %tmp2137, %dec_label_pc_11150.preheader ]
  %stack_var_-72.1263 = phi i32 [ %stack_var_-72.0, %dec_label_pc_11144.dec_label_pc_11104_crit_edge ], [ 0, %dec_label_pc_11150.preheader ]
  %storemerge77262 = phi i32 [ %v1_11148, %dec_label_pc_11144.dec_label_pc_11104_crit_edge ], [ 0, %dec_label_pc_11150.preheader ]
  %v2_11114 = icmp ult i8 %v2_11110, 13
  %v3_11114 = icmp ne i1 %v2_11114, true
  store i1 %v3_11114, i1* %cpsr_c.global-to-local, align 1
  %v9_11114 = icmp eq i8 %v2_11110, 13
  store i1 %v9_11114, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11114, label %dec_label_pc_11144, label %dec_label_pc_1111c

dec_label_pc_1111c:                               ; preds = %dec_label_pc_11104
  %v1_11120 = add i32 %stack_var_-72.1263, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_11134 = load i8, i8* %v1_1115c265, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_11140 = add i32 %v2_128d8, %stack_var_-72.1263
  %v4_11140 = inttoptr i32 %v3_11140 to i8*
  store i8 %v2_11134, i8* %v4_11140, align 1
  br label %dec_label_pc_11144

dec_label_pc_11144:                               ; preds = %dec_label_pc_1111c, %dec_label_pc_11104
  %stack_var_-72.0 = phi i32 [ %stack_var_-72.1263, %dec_label_pc_11104 ], [ %v1_11120, %dec_label_pc_1111c ]
  %v1_11148 = add i32 %storemerge77262, 1
  %v2_11158 = add i32 %v1_11148, %v2_11034
  %v1_1115c = inttoptr i32 %v2_11158 to i8*
  %v2_1115c = load i8, i8* %v1_1115c, align 1
  %v2_11160 = icmp ult i8 %v2_1115c, 16
  %v3_11160 = icmp ne i1 %v2_11160, true
  store i1 %v3_11160, i1* %cpsr_c.global-to-local, align 1
  %v9_11160 = icmp eq i8 %v2_1115c, 16
  store i1 %v9_11160, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11160, label %dec_label_pc_11168, label %dec_label_pc_11144.dec_label_pc_11104_crit_edge

dec_label_pc_11144.dec_label_pc_11104_crit_edge:  ; preds = %dec_label_pc_11144
  %v2_11110.pre = load i8, i8* %v1_1115c, align 1
  br label %dec_label_pc_11104

dec_label_pc_11168:                               ; preds = %dec_label_pc_11144, %dec_label_pc_11150.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_11174 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_11174, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_111cc

dec_label_pc_11188:                               ; preds = %dec_label_pc_110b0, %dec_label_pc_11084
  %stack_var_-28.0 = phi i8* [ %tmp2137, %dec_label_pc_11084 ], [ %v4_110bc, %dec_label_pc_110b0 ]
  %v2_1118c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_1118c, i32* %r0.global-to-local, align 4
  %v4_1119c = ptrtoint i8* %stack_var_-28.0 to i32
  %v1_111a4 = sub i32 %v2_12938, %v4_1119c
  store i32 %v4_1119c, i32* %r1.global-to-local, align 4
  %v2_111b0 = bitcast i8* %stack_var_-28.0 to i32*
  %v4_111b0 = call i32 @read(i32 %v2_1118c, i32* %v2_111b0, i32 %v1_111a4)
  store i32 %v4_111b0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_111bc = icmp eq i32 %v4_111b0, 0
  store i1 %v7_111bc, i1* %cpsr_z.global-to-local, align 1
  %v8_111c0 = icmp sgt i32 %v4_111b0, 0
  br i1 %v8_111c0, label %dec_label_pc_110b0, label %dec_label_pc_111cc

dec_label_pc_111cc:                               ; preds = %dec_label_pc_11188, %dec_label_pc_110d4, %dec_label_pc_11168
  %stack_var_-28.1 = phi i8* [ %v4_110bc, %dec_label_pc_110d4 ], [ %v4_110bc, %dec_label_pc_11168 ], [ %stack_var_-28.0, %dec_label_pc_11188 ]
  %stack_var_-24.0 = phi i32 [ 1, %dec_label_pc_110d4 ], [ 2, %dec_label_pc_11168 ], [ 1, %dec_label_pc_11188 ]
  store i8 0, i8* %stack_var_-28.1, align 1
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_12d10.backedge.thread:               ; preds = %dec_label_pc_11034, %dec_label_pc_1142c, %dec_label_pc_112e0, %dec_label_pc_12490, %dec_label_pc_11fcc, %dec_label_pc_11990, %dec_label_pc_1186c, %dec_label_pc_11714, %dec_label_pc_115bc, %dec_label_pc_11378, %dec_label_pc_1140c, %dec_label_pc_1122c, %dec_label_pc_112c0, %dec_label_pc_111cc, %dec_label_pc_12d10.loopexit95, %dec_label_pc_12d10.loopexit96, %dec_label_pc_12d10.loopexit97
  %stack_var_-44.17.be.ph = phi i32 [ %tmp2166, %dec_label_pc_12d10.loopexit97 ], [ %tmp2165, %dec_label_pc_12d10.loopexit96 ], [ %tmp2164, %dec_label_pc_12d10.loopexit95 ], [ %stack_var_-44.17266.ph, %dec_label_pc_111cc ], [ %stack_var_-44.17266.ph, %dec_label_pc_112c0 ], [ %stack_var_-44.17266.ph, %dec_label_pc_1122c ], [ %stack_var_-44.17266.ph, %dec_label_pc_1140c ], [ %stack_var_-44.17266.ph, %dec_label_pc_11378 ], [ %stack_var_-44.17266.ph, %dec_label_pc_115bc ], [ %stack_var_-44.17266.ph, %dec_label_pc_11714 ], [ %stack_var_-44.17266.ph, %dec_label_pc_1186c ], [ %stack_var_-44.17266.ph, %dec_label_pc_11990 ], [ %stack_var_-44.17266.ph, %dec_label_pc_11fcc ], [ %stack_var_-44.17266.ph, %dec_label_pc_12490 ], [ %stack_var_-44.17266.ph, %dec_label_pc_112e0 ], [ %stack_var_-44.17266.ph, %dec_label_pc_1142c ], [ %stack_var_-44.17266.ph, %dec_label_pc_11034 ]
  %stack_var_-40.33.be.ph = phi i32 [ %stack_var_-40.22, %dec_label_pc_12d10.loopexit97 ], [ %stack_var_-40.14, %dec_label_pc_12d10.loopexit96 ], [ %stack_var_-40.6, %dec_label_pc_12d10.loopexit95 ], [ %stack_var_-40.33267.ph, %dec_label_pc_111cc ], [ %stack_var_-40.33267.ph, %dec_label_pc_112c0 ], [ %stack_var_-40.33267.ph, %dec_label_pc_1122c ], [ %stack_var_-40.33267.ph, %dec_label_pc_1140c ], [ %stack_var_-40.33267.ph, %dec_label_pc_11378 ], [ %stack_var_-40.33267.ph, %dec_label_pc_115bc ], [ %stack_var_-40.33267.ph, %dec_label_pc_11714 ], [ %stack_var_-40.33267.ph, %dec_label_pc_1186c ], [ %stack_var_-40.33267.ph, %dec_label_pc_11990 ], [ %stack_var_-40.33267.ph, %dec_label_pc_11fcc ], [ %stack_var_-40.33267.ph, %dec_label_pc_12490 ], [ %stack_var_-40.33267.ph, %dec_label_pc_112e0 ], [ %stack_var_-40.33267.ph, %dec_label_pc_1142c ], [ %stack_var_-40.33267.ph, %dec_label_pc_11034 ]
  %stack_var_-24.7.be.ph = phi i32 [ %stack_var_-24.6, %dec_label_pc_12d10.loopexit97 ], [ %stack_var_-24.5, %dec_label_pc_12d10.loopexit96 ], [ %stack_var_-24.4, %dec_label_pc_12d10.loopexit95 ], [ %stack_var_-24.0, %dec_label_pc_111cc ], [ 3, %dec_label_pc_112c0 ], [ 2, %dec_label_pc_1122c ], [ 4, %dec_label_pc_1140c ], [ 3, %dec_label_pc_11378 ], [ %stack_var_-24.1, %dec_label_pc_115bc ], [ %stack_var_-24.2, %dec_label_pc_11714 ], [ %stack_var_-24.3, %dec_label_pc_1186c ], [ %stack_var_-24.4, %dec_label_pc_11990 ], [ %stack_var_-24.5, %dec_label_pc_11fcc ], [ %stack_var_-24.6, %dec_label_pc_12490 ], [ 2, %dec_label_pc_112e0 ], [ 3, %dec_label_pc_1142c ], [ %stack_var_-24.7269.ph, %dec_label_pc_11034 ]
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 true, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_11034.outer

dec_label_pc_12d10.backedge:                      ; preds = %dec_label_pc_1295c, %dec_label_pc_12cf8.loopexit
  %stack_var_-44.16 = phi i32 [ %stack_var_-44.17266, %dec_label_pc_1295c ], [ %tmp2163, %dec_label_pc_12cf8.loopexit ]
  %v2_12cfc = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12cfc = ptrtoint %_IO_FILE* %v2_12cfc to i32
  store i32 %v3_12cfc, i32* %r0.global-to-local, align 4
  %v3_12d04 = call i32 @fclose(%_IO_FILE* %v2_12cfc)
  store i32 %v3_12d04, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_12d14 = icmp eq i32 %stack_var_-32.0, 0
  store i1 %v7_12d14, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_12d14, label %dec_label_pc_11034, label %dec_label_pc_15168.preheader

dec_label_pc_111dc:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15b68.162 to i32), i32* %r0.global-to-local, align 4
  %v3_111e0 = call i32 @puts(i8* bitcast (i8** @global_var_15b68.162 to i8*))
  %v2_111e8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15b80.164 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_111e8, i32* %r0.global-to-local, align 4
  %v4_111f8 = call i32 @write(i32 %v2_111e8, i32* bitcast ([6 x i8]* @global_var_15b80.164 to i32*), i32 5)
  store i32 %v4_111f8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_112e0

dec_label_pc_11208:                               ; preds = %dec_label_pc_112e0
  %v2_11210 = add i32 %v4_11308, %v4_112f4
  %v4_11214 = inttoptr i32 %v2_11210 to i8*
  %v1_1121c = add i32 %v2_11210, -1
  %v1_11220 = inttoptr i32 %v1_1121c to i8*
  %v2_11220 = load i8, i8* %v1_11220, align 1
  %v2_11224 = icmp ult i8 %v2_11220, 62
  %v3_11224 = icmp ne i1 %v2_11224, true
  store i1 %v3_11224, i1* %cpsr_c.global-to-local, align 1
  %v9_11224 = icmp eq i8 %v2_11220, 62
  store i1 %v9_11224, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11224, label %dec_label_pc_1122c, label %dec_label_pc_112e0

dec_label_pc_1122c:                               ; preds = %dec_label_pc_11208
  store i32 ptrtoint ([3 x i8]* @global_var_15b88.166 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_11238 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15b88.166, i32 0, i32 0))
  %v8_11238 = ptrtoint i8* %v6_11238 to i32
  store i32 %v8_11238, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11240 = icmp eq i8* %v6_11238, null
  store i1 %v7_11240, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_11240, label %dec_label_pc_12d10.backedge.thread, label %dec_label_pc_112a8.preheader

dec_label_pc_112a8.preheader:                     ; preds = %dec_label_pc_1122c
  %v2_112b4246 = load i8, i8* %tmp2137, align 4
  %v2_112b8248 = icmp ult i8 %v2_112b4246, 16
  %v3_112b8249 = icmp ne i1 %v2_112b8248, true
  store i1 %v3_112b8249, i1* %cpsr_c.global-to-local, align 1
  %v9_112b8250 = icmp eq i8 %v2_112b4246, 16
  store i1 %v9_112b8250, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_112b8250, label %dec_label_pc_112c0, label %dec_label_pc_1125c

dec_label_pc_1125c:                               ; preds = %dec_label_pc_112a8.preheader, %dec_label_pc_1129c.dec_label_pc_1125c_crit_edge
  %v2_11268 = phi i8 [ %v2_11268.pre, %dec_label_pc_1129c.dec_label_pc_1125c_crit_edge ], [ %v2_112b4246, %dec_label_pc_112a8.preheader ]
  %v1_112b4254 = phi i8* [ %v1_112b4, %dec_label_pc_1129c.dec_label_pc_1125c_crit_edge ], [ %tmp2137, %dec_label_pc_112a8.preheader ]
  %stack_var_-80.1252 = phi i32 [ %stack_var_-80.0, %dec_label_pc_1129c.dec_label_pc_1125c_crit_edge ], [ 0, %dec_label_pc_112a8.preheader ]
  %storemerge76251 = phi i32 [ %v1_112a0, %dec_label_pc_1129c.dec_label_pc_1125c_crit_edge ], [ 0, %dec_label_pc_112a8.preheader ]
  %v2_1126c = icmp ult i8 %v2_11268, 13
  %v3_1126c = icmp ne i1 %v2_1126c, true
  store i1 %v3_1126c, i1* %cpsr_c.global-to-local, align 1
  %v9_1126c = icmp eq i8 %v2_11268, 13
  store i1 %v9_1126c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1126c, label %dec_label_pc_1129c, label %dec_label_pc_11274

dec_label_pc_11274:                               ; preds = %dec_label_pc_1125c
  %v1_11278 = add i32 %stack_var_-80.1252, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_1128c = load i8, i8* %v1_112b4254, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_11298 = add i32 %v2_128d8, %stack_var_-80.1252
  %v4_11298 = inttoptr i32 %v3_11298 to i8*
  store i8 %v2_1128c, i8* %v4_11298, align 1
  br label %dec_label_pc_1129c

dec_label_pc_1129c:                               ; preds = %dec_label_pc_11274, %dec_label_pc_1125c
  %stack_var_-80.0 = phi i32 [ %stack_var_-80.1252, %dec_label_pc_1125c ], [ %v1_11278, %dec_label_pc_11274 ]
  %v1_112a0 = add i32 %storemerge76251, 1
  %v2_112b0 = add i32 %v1_112a0, %v2_11034
  %v1_112b4 = inttoptr i32 %v2_112b0 to i8*
  %v2_112b4 = load i8, i8* %v1_112b4, align 1
  %v2_112b8 = icmp ult i8 %v2_112b4, 16
  %v3_112b8 = icmp ne i1 %v2_112b8, true
  store i1 %v3_112b8, i1* %cpsr_c.global-to-local, align 1
  %v9_112b8 = icmp eq i8 %v2_112b4, 16
  store i1 %v9_112b8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_112b8, label %dec_label_pc_112c0, label %dec_label_pc_1129c.dec_label_pc_1125c_crit_edge

dec_label_pc_1129c.dec_label_pc_1125c_crit_edge:  ; preds = %dec_label_pc_1129c
  %v2_11268.pre = load i8, i8* %v1_112b4, align 1
  br label %dec_label_pc_1125c

dec_label_pc_112c0:                               ; preds = %dec_label_pc_1129c, %dec_label_pc_112a8.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_112cc = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_112cc, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_112e0:                               ; preds = %dec_label_pc_11208, %dec_label_pc_111dc
  %stack_var_-28.2 = phi i8* [ %tmp2137, %dec_label_pc_111dc ], [ %v4_11214, %dec_label_pc_11208 ]
  %v2_112e4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_112e4, i32* %r0.global-to-local, align 4
  %v4_112f4 = ptrtoint i8* %stack_var_-28.2 to i32
  %v1_112fc = sub i32 %v2_12938, %v4_112f4
  store i32 %v4_112f4, i32* %r1.global-to-local, align 4
  %v2_11308 = bitcast i8* %stack_var_-28.2 to i32*
  %v4_11308 = call i32 @read(i32 %v2_112e4, i32* %v2_11308, i32 %v1_112fc)
  store i32 %v4_11308, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11314 = icmp eq i32 %v4_11308, 0
  store i1 %v7_11314, i1* %cpsr_z.global-to-local, align 1
  %v8_11318 = icmp sgt i32 %v4_11308, 0
  br i1 %v8_11318, label %dec_label_pc_11208, label %dec_label_pc_12d10.backedge.thread

dec_label_pc_11328:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15b8c.168 to i32), i32* %r0.global-to-local, align 4
  %v3_1132c = call i32 @puts(i8* bitcast (i8** @global_var_15b8c.168 to i8*))
  %v2_11334 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15ba4.170 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11334, i32* %r0.global-to-local, align 4
  %v4_11344 = call i32 @write(i32 %v2_11334, i32* bitcast ([6 x i8]* @global_var_15ba4.170 to i32*), i32 5)
  store i32 %v4_11344, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_1142c

dec_label_pc_11354:                               ; preds = %dec_label_pc_1142c
  %v2_1135c = add i32 %v4_11454, %v4_11440
  %v4_11360 = inttoptr i32 %v2_1135c to i8*
  %v1_11368 = add i32 %v2_1135c, -1
  %v1_1136c = inttoptr i32 %v1_11368 to i8*
  %v2_1136c = load i8, i8* %v1_1136c, align 1
  %v2_11370 = icmp ult i8 %v2_1136c, 62
  %v3_11370 = icmp ne i1 %v2_11370, true
  store i1 %v3_11370, i1* %cpsr_c.global-to-local, align 1
  %v9_11370 = icmp eq i8 %v2_1136c, 62
  store i1 %v9_11370, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11370, label %dec_label_pc_11378, label %dec_label_pc_1142c

dec_label_pc_11378:                               ; preds = %dec_label_pc_11354
  store i32 ptrtoint ([3 x i8]* @global_var_15b88.166 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_11384 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15b88.166, i32 0, i32 0))
  %v8_11384 = ptrtoint i8* %v6_11384 to i32
  store i32 %v8_11384, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_1138c = icmp eq i8* %v6_11384, null
  store i1 %v7_1138c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_1138c, label %dec_label_pc_12d10.backedge.thread, label %dec_label_pc_113f4.preheader

dec_label_pc_113f4.preheader:                     ; preds = %dec_label_pc_11378
  %v2_11400235 = load i8, i8* %tmp2137, align 4
  %v2_11404237 = icmp ult i8 %v2_11400235, 16
  %v3_11404238 = icmp ne i1 %v2_11404237, true
  store i1 %v3_11404238, i1* %cpsr_c.global-to-local, align 1
  %v9_11404239 = icmp eq i8 %v2_11400235, 16
  store i1 %v9_11404239, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11404239, label %dec_label_pc_1140c, label %dec_label_pc_113a8

dec_label_pc_113a8:                               ; preds = %dec_label_pc_113f4.preheader, %dec_label_pc_113e8.dec_label_pc_113a8_crit_edge
  %v2_113b4 = phi i8 [ %v2_113b4.pre, %dec_label_pc_113e8.dec_label_pc_113a8_crit_edge ], [ %v2_11400235, %dec_label_pc_113f4.preheader ]
  %v1_11400243 = phi i8* [ %v1_11400, %dec_label_pc_113e8.dec_label_pc_113a8_crit_edge ], [ %tmp2137, %dec_label_pc_113f4.preheader ]
  %stack_var_-88.1241 = phi i32 [ %stack_var_-88.0, %dec_label_pc_113e8.dec_label_pc_113a8_crit_edge ], [ 0, %dec_label_pc_113f4.preheader ]
  %storemerge75240 = phi i32 [ %v1_113ec, %dec_label_pc_113e8.dec_label_pc_113a8_crit_edge ], [ 0, %dec_label_pc_113f4.preheader ]
  %v2_113b8 = icmp ult i8 %v2_113b4, 13
  %v3_113b8 = icmp ne i1 %v2_113b8, true
  store i1 %v3_113b8, i1* %cpsr_c.global-to-local, align 1
  %v9_113b8 = icmp eq i8 %v2_113b4, 13
  store i1 %v9_113b8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_113b8, label %dec_label_pc_113e8, label %dec_label_pc_113c0

dec_label_pc_113c0:                               ; preds = %dec_label_pc_113a8
  %v1_113c4 = add i32 %stack_var_-88.1241, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_113d8 = load i8, i8* %v1_11400243, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_113e4 = add i32 %v2_128d8, %stack_var_-88.1241
  %v4_113e4 = inttoptr i32 %v3_113e4 to i8*
  store i8 %v2_113d8, i8* %v4_113e4, align 1
  br label %dec_label_pc_113e8

dec_label_pc_113e8:                               ; preds = %dec_label_pc_113c0, %dec_label_pc_113a8
  %stack_var_-88.0 = phi i32 [ %stack_var_-88.1241, %dec_label_pc_113a8 ], [ %v1_113c4, %dec_label_pc_113c0 ]
  %v1_113ec = add i32 %storemerge75240, 1
  %v2_113fc = add i32 %v1_113ec, %v2_11034
  %v1_11400 = inttoptr i32 %v2_113fc to i8*
  %v2_11400 = load i8, i8* %v1_11400, align 1
  %v2_11404 = icmp ult i8 %v2_11400, 16
  %v3_11404 = icmp ne i1 %v2_11404, true
  store i1 %v3_11404, i1* %cpsr_c.global-to-local, align 1
  %v9_11404 = icmp eq i8 %v2_11400, 16
  store i1 %v9_11404, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11404, label %dec_label_pc_1140c, label %dec_label_pc_113e8.dec_label_pc_113a8_crit_edge

dec_label_pc_113e8.dec_label_pc_113a8_crit_edge:  ; preds = %dec_label_pc_113e8
  %v2_113b4.pre = load i8, i8* %v1_11400, align 1
  br label %dec_label_pc_113a8

dec_label_pc_1140c:                               ; preds = %dec_label_pc_113e8, %dec_label_pc_113f4.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_11418 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_11418, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_1142c:                               ; preds = %dec_label_pc_11354, %dec_label_pc_11328
  %stack_var_-28.3 = phi i8* [ %tmp2137, %dec_label_pc_11328 ], [ %v4_11360, %dec_label_pc_11354 ]
  %v2_11430 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_11430, i32* %r0.global-to-local, align 4
  %v4_11440 = ptrtoint i8* %stack_var_-28.3 to i32
  %v1_11448 = sub i32 %v2_12938, %v4_11440
  store i32 %v4_11440, i32* %r1.global-to-local, align 4
  %v2_11454 = bitcast i8* %stack_var_-28.3 to i32*
  %v4_11454 = call i32 @read(i32 %v2_11430, i32* %v2_11454, i32 %v1_11448)
  store i32 %v4_11454, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11460 = icmp eq i32 %v4_11454, 0
  store i1 %v7_11460, i1* %cpsr_z.global-to-local, align 1
  %v8_11464 = icmp sgt i32 %v4_11454, 0
  br i1 %v8_11464, label %dec_label_pc_11354, label %dec_label_pc_12d10.backedge.thread

dec_label_pc_11474:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15bac.172 to i32), i32* %r0.global-to-local, align 4
  %v3_11478 = call i32 @puts(i8* bitcast (i8** @global_var_15bac.172 to i8*))
  %v2_11480 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([5 x i8]* @global_var_15bc8.174 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11480, i32* %r0.global-to-local, align 4
  %v4_11490 = call i32 @write(i32 %v2_11480, i32* bitcast ([5 x i8]* @global_var_15bc8.174 to i32*), i32 4)
  store i32 %v4_11490, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11578

dec_label_pc_114a0:                               ; preds = %dec_label_pc_11578
  %v2_114a8 = add i32 %v4_115a0, %v4_1158c
  %v4_114ac = inttoptr i32 %v2_114a8 to i8*
  %v1_114b4 = add i32 %v2_114a8, -1
  %v1_114b8 = inttoptr i32 %v1_114b4 to i8*
  %v2_114b8 = load i8, i8* %v1_114b8, align 1
  %v2_114bc = icmp ult i8 %v2_114b8, 62
  %v3_114bc = icmp ne i1 %v2_114bc, true
  store i1 %v3_114bc, i1* %cpsr_c.global-to-local, align 1
  %v9_114bc = icmp eq i8 %v2_114b8, 62
  store i1 %v9_114bc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_114bc, label %dec_label_pc_114c4, label %dec_label_pc_11578

dec_label_pc_114c4:                               ; preds = %dec_label_pc_114a0
  store i32 ptrtoint ([7 x i8]* @global_var_15b54.158 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_114d0 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15b54.158, i32 0, i32 0))
  %v8_114d0 = ptrtoint i8* %v6_114d0 to i32
  store i32 %v8_114d0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_114d8 = icmp eq i8* %v6_114d0, null
  store i1 %v7_114d8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_114d8, label %dec_label_pc_115bc, label %dec_label_pc_11540.preheader

dec_label_pc_11540.preheader:                     ; preds = %dec_label_pc_114c4
  %v2_1154c224 = load i8, i8* %tmp2137, align 4
  %v2_11550226 = icmp ult i8 %v2_1154c224, 16
  %v3_11550227 = icmp ne i1 %v2_11550226, true
  store i1 %v3_11550227, i1* %cpsr_c.global-to-local, align 1
  %v9_11550228 = icmp eq i8 %v2_1154c224, 16
  store i1 %v9_11550228, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11550228, label %dec_label_pc_11558, label %dec_label_pc_114f4

dec_label_pc_114f4:                               ; preds = %dec_label_pc_11540.preheader, %dec_label_pc_11534.dec_label_pc_114f4_crit_edge
  %v2_11500 = phi i8 [ %v2_11500.pre, %dec_label_pc_11534.dec_label_pc_114f4_crit_edge ], [ %v2_1154c224, %dec_label_pc_11540.preheader ]
  %v1_1154c232 = phi i8* [ %v1_1154c, %dec_label_pc_11534.dec_label_pc_114f4_crit_edge ], [ %tmp2137, %dec_label_pc_11540.preheader ]
  %stack_var_-96.1230 = phi i32 [ %stack_var_-96.0, %dec_label_pc_11534.dec_label_pc_114f4_crit_edge ], [ 0, %dec_label_pc_11540.preheader ]
  %storemerge74229 = phi i32 [ %v1_11538, %dec_label_pc_11534.dec_label_pc_114f4_crit_edge ], [ 0, %dec_label_pc_11540.preheader ]
  %v2_11504 = icmp ult i8 %v2_11500, 13
  %v3_11504 = icmp ne i1 %v2_11504, true
  store i1 %v3_11504, i1* %cpsr_c.global-to-local, align 1
  %v9_11504 = icmp eq i8 %v2_11500, 13
  store i1 %v9_11504, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11504, label %dec_label_pc_11534, label %dec_label_pc_1150c

dec_label_pc_1150c:                               ; preds = %dec_label_pc_114f4
  %v1_11510 = add i32 %stack_var_-96.1230, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_11524 = load i8, i8* %v1_1154c232, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_11530 = add i32 %v2_128d8, %stack_var_-96.1230
  %v4_11530 = inttoptr i32 %v3_11530 to i8*
  store i8 %v2_11524, i8* %v4_11530, align 1
  br label %dec_label_pc_11534

dec_label_pc_11534:                               ; preds = %dec_label_pc_1150c, %dec_label_pc_114f4
  %stack_var_-96.0 = phi i32 [ %stack_var_-96.1230, %dec_label_pc_114f4 ], [ %v1_11510, %dec_label_pc_1150c ]
  %v1_11538 = add i32 %storemerge74229, 1
  %v2_11548 = add i32 %v1_11538, %v2_11034
  %v1_1154c = inttoptr i32 %v2_11548 to i8*
  %v2_1154c = load i8, i8* %v1_1154c, align 1
  %v2_11550 = icmp ult i8 %v2_1154c, 16
  %v3_11550 = icmp ne i1 %v2_11550, true
  store i1 %v3_11550, i1* %cpsr_c.global-to-local, align 1
  %v9_11550 = icmp eq i8 %v2_1154c, 16
  store i1 %v9_11550, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11550, label %dec_label_pc_11558, label %dec_label_pc_11534.dec_label_pc_114f4_crit_edge

dec_label_pc_11534.dec_label_pc_114f4_crit_edge:  ; preds = %dec_label_pc_11534
  %v2_11500.pre = load i8, i8* %v1_1154c, align 1
  br label %dec_label_pc_114f4

dec_label_pc_11558:                               ; preds = %dec_label_pc_11534, %dec_label_pc_11540.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_11564 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_11564, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_115bc

dec_label_pc_11578:                               ; preds = %dec_label_pc_114a0, %dec_label_pc_11474
  %stack_var_-28.4 = phi i8* [ %tmp2137, %dec_label_pc_11474 ], [ %v4_114ac, %dec_label_pc_114a0 ]
  %v2_1157c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_1157c, i32* %r0.global-to-local, align 4
  %v4_1158c = ptrtoint i8* %stack_var_-28.4 to i32
  %v1_11594 = sub i32 %v2_12938, %v4_1158c
  store i32 %v4_1158c, i32* %r1.global-to-local, align 4
  %v2_115a0 = bitcast i8* %stack_var_-28.4 to i32*
  %v4_115a0 = call i32 @read(i32 %v2_1157c, i32* %v2_115a0, i32 %v1_11594)
  store i32 %v4_115a0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_115ac = icmp eq i32 %v4_115a0, 0
  store i1 %v7_115ac, i1* %cpsr_z.global-to-local, align 1
  %v8_115b0 = icmp sgt i32 %v4_115a0, 0
  br i1 %v8_115b0, label %dec_label_pc_114a0, label %dec_label_pc_115bc

dec_label_pc_115bc:                               ; preds = %dec_label_pc_11578, %dec_label_pc_114c4, %dec_label_pc_11558
  %stack_var_-28.5 = phi i8* [ %v4_114ac, %dec_label_pc_114c4 ], [ %v4_114ac, %dec_label_pc_11558 ], [ %stack_var_-28.4, %dec_label_pc_11578 ]
  %stack_var_-24.1 = phi i32 [ 4, %dec_label_pc_114c4 ], [ 5, %dec_label_pc_11558 ], [ 4, %dec_label_pc_11578 ]
  store i8 0, i8* %stack_var_-28.5, align 1
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_115cc:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15bd0.176 to i32), i32* %r0.global-to-local, align 4
  %v3_115d0 = call i32 @puts(i8* bitcast (i8** @global_var_15bd0.176 to i8*))
  %v2_115d8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([8 x i8]* @global_var_15bec.178 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_115d8, i32* %r0.global-to-local, align 4
  %v4_115e8 = call i32 @write(i32 %v2_115d8, i32* bitcast ([8 x i8]* @global_var_15bec.178 to i32*), i32 7)
  store i32 %v4_115e8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_116d0

dec_label_pc_115f8:                               ; preds = %dec_label_pc_116d0
  %v2_11600 = add i32 %v4_116f8, %v4_116e4
  %v4_11604 = inttoptr i32 %v2_11600 to i8*
  %v1_1160c = add i32 %v2_11600, -1
  %v1_11610 = inttoptr i32 %v1_1160c to i8*
  %v2_11610 = load i8, i8* %v1_11610, align 1
  %v2_11614 = icmp ult i8 %v2_11610, 62
  %v3_11614 = icmp ne i1 %v2_11614, true
  store i1 %v3_11614, i1* %cpsr_c.global-to-local, align 1
  %v9_11614 = icmp eq i8 %v2_11610, 62
  store i1 %v9_11614, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11614, label %dec_label_pc_1161c, label %dec_label_pc_116d0

dec_label_pc_1161c:                               ; preds = %dec_label_pc_115f8
  store i32 ptrtoint ([3 x i8]* @global_var_15b88.166 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_11628 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15b88.166, i32 0, i32 0))
  %v8_11628 = ptrtoint i8* %v6_11628 to i32
  store i32 %v8_11628, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11630 = icmp eq i8* %v6_11628, null
  store i1 %v7_11630, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_11630, label %dec_label_pc_11714, label %dec_label_pc_11698.preheader

dec_label_pc_11698.preheader:                     ; preds = %dec_label_pc_1161c
  %v2_116a4213 = load i8, i8* %tmp2137, align 4
  %v2_116a8215 = icmp ult i8 %v2_116a4213, 16
  %v3_116a8216 = icmp ne i1 %v2_116a8215, true
  store i1 %v3_116a8216, i1* %cpsr_c.global-to-local, align 1
  %v9_116a8217 = icmp eq i8 %v2_116a4213, 16
  store i1 %v9_116a8217, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_116a8217, label %dec_label_pc_116b0, label %dec_label_pc_1164c

dec_label_pc_1164c:                               ; preds = %dec_label_pc_11698.preheader, %dec_label_pc_1168c.dec_label_pc_1164c_crit_edge
  %v2_11658 = phi i8 [ %v2_11658.pre, %dec_label_pc_1168c.dec_label_pc_1164c_crit_edge ], [ %v2_116a4213, %dec_label_pc_11698.preheader ]
  %v1_116a4221 = phi i8* [ %v1_116a4, %dec_label_pc_1168c.dec_label_pc_1164c_crit_edge ], [ %tmp2137, %dec_label_pc_11698.preheader ]
  %stack_var_-104.1219 = phi i32 [ %stack_var_-104.0, %dec_label_pc_1168c.dec_label_pc_1164c_crit_edge ], [ 0, %dec_label_pc_11698.preheader ]
  %storemerge73218 = phi i32 [ %v1_11690, %dec_label_pc_1168c.dec_label_pc_1164c_crit_edge ], [ 0, %dec_label_pc_11698.preheader ]
  %v2_1165c = icmp ult i8 %v2_11658, 13
  %v3_1165c = icmp ne i1 %v2_1165c, true
  store i1 %v3_1165c, i1* %cpsr_c.global-to-local, align 1
  %v9_1165c = icmp eq i8 %v2_11658, 13
  store i1 %v9_1165c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1165c, label %dec_label_pc_1168c, label %dec_label_pc_11664

dec_label_pc_11664:                               ; preds = %dec_label_pc_1164c
  %v1_11668 = add i32 %stack_var_-104.1219, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_1167c = load i8, i8* %v1_116a4221, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_11688 = add i32 %v2_128d8, %stack_var_-104.1219
  %v4_11688 = inttoptr i32 %v3_11688 to i8*
  store i8 %v2_1167c, i8* %v4_11688, align 1
  br label %dec_label_pc_1168c

dec_label_pc_1168c:                               ; preds = %dec_label_pc_11664, %dec_label_pc_1164c
  %stack_var_-104.0 = phi i32 [ %stack_var_-104.1219, %dec_label_pc_1164c ], [ %v1_11668, %dec_label_pc_11664 ]
  %v1_11690 = add i32 %storemerge73218, 1
  %v2_116a0 = add i32 %v1_11690, %v2_11034
  %v1_116a4 = inttoptr i32 %v2_116a0 to i8*
  %v2_116a4 = load i8, i8* %v1_116a4, align 1
  %v2_116a8 = icmp ult i8 %v2_116a4, 16
  %v3_116a8 = icmp ne i1 %v2_116a8, true
  store i1 %v3_116a8, i1* %cpsr_c.global-to-local, align 1
  %v9_116a8 = icmp eq i8 %v2_116a4, 16
  store i1 %v9_116a8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_116a8, label %dec_label_pc_116b0, label %dec_label_pc_1168c.dec_label_pc_1164c_crit_edge

dec_label_pc_1168c.dec_label_pc_1164c_crit_edge:  ; preds = %dec_label_pc_1168c
  %v2_11658.pre = load i8, i8* %v1_116a4, align 1
  br label %dec_label_pc_1164c

dec_label_pc_116b0:                               ; preds = %dec_label_pc_1168c, %dec_label_pc_11698.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_116bc = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_116bc, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11714

dec_label_pc_116d0:                               ; preds = %dec_label_pc_115f8, %dec_label_pc_115cc
  %stack_var_-28.6 = phi i8* [ %tmp2137, %dec_label_pc_115cc ], [ %v4_11604, %dec_label_pc_115f8 ]
  %v2_116d4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_116d4, i32* %r0.global-to-local, align 4
  %v4_116e4 = ptrtoint i8* %stack_var_-28.6 to i32
  %v1_116ec = sub i32 %v2_12938, %v4_116e4
  store i32 %v4_116e4, i32* %r1.global-to-local, align 4
  %v2_116f8 = bitcast i8* %stack_var_-28.6 to i32*
  %v4_116f8 = call i32 @read(i32 %v2_116d4, i32* %v2_116f8, i32 %v1_116ec)
  store i32 %v4_116f8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11704 = icmp eq i32 %v4_116f8, 0
  store i1 %v7_11704, i1* %cpsr_z.global-to-local, align 1
  %v8_11708 = icmp sgt i32 %v4_116f8, 0
  br i1 %v8_11708, label %dec_label_pc_115f8, label %dec_label_pc_11714

dec_label_pc_11714:                               ; preds = %dec_label_pc_116d0, %dec_label_pc_1161c, %dec_label_pc_116b0
  %stack_var_-28.7 = phi i8* [ %v4_11604, %dec_label_pc_1161c ], [ %v4_11604, %dec_label_pc_116b0 ], [ %stack_var_-28.6, %dec_label_pc_116d0 ]
  %stack_var_-24.2 = phi i32 [ 5, %dec_label_pc_1161c ], [ 6, %dec_label_pc_116b0 ], [ 5, %dec_label_pc_116d0 ]
  store i8 0, i8* %stack_var_-28.7, align 1
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_11724:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15bf4.180 to i32), i32* %r0.global-to-local, align 4
  %v3_11728 = call i32 @puts(i8* bitcast (i8** @global_var_15bf4.180 to i8*))
  %v2_11730 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15c08.182 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11730, i32* %r0.global-to-local, align 4
  %v4_11740 = call i32 @write(i32 %v2_11730, i32* bitcast ([6 x i8]* @global_var_15c08.182 to i32*), i32 5)
  store i32 %v4_11740, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11828

dec_label_pc_11750:                               ; preds = %dec_label_pc_11828
  %v2_11758 = add i32 %v4_11850, %v4_1183c
  %v4_1175c = inttoptr i32 %v2_11758 to i8*
  %v1_11764 = add i32 %v2_11758, -1
  %v1_11768 = inttoptr i32 %v1_11764 to i8*
  %v2_11768 = load i8, i8* %v1_11768, align 1
  %v2_1176c = icmp ult i8 %v2_11768, 62
  %v3_1176c = icmp ne i1 %v2_1176c, true
  store i1 %v3_1176c, i1* %cpsr_c.global-to-local, align 1
  %v9_1176c = icmp eq i8 %v2_11768, 62
  store i1 %v9_1176c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1176c, label %dec_label_pc_11774, label %dec_label_pc_11828

dec_label_pc_11774:                               ; preds = %dec_label_pc_11750
  store i32 ptrtoint ([5 x i8]* @global_var_15c10.184 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_11780 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @global_var_15c10.184, i32 0, i32 0))
  %v8_11780 = ptrtoint i8* %v6_11780 to i32
  store i32 %v8_11780, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11788 = icmp eq i8* %v6_11780, null
  store i1 %v7_11788, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_11788, label %dec_label_pc_1186c, label %dec_label_pc_117f0.preheader

dec_label_pc_117f0.preheader:                     ; preds = %dec_label_pc_11774
  %v2_117fc202 = load i8, i8* %tmp2137, align 4
  %v2_11800204 = icmp ult i8 %v2_117fc202, 16
  %v3_11800205 = icmp ne i1 %v2_11800204, true
  store i1 %v3_11800205, i1* %cpsr_c.global-to-local, align 1
  %v9_11800206 = icmp eq i8 %v2_117fc202, 16
  store i1 %v9_11800206, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11800206, label %dec_label_pc_11808, label %dec_label_pc_117a4

dec_label_pc_117a4:                               ; preds = %dec_label_pc_117f0.preheader, %dec_label_pc_117e4.dec_label_pc_117a4_crit_edge
  %v2_117b0 = phi i8 [ %v2_117b0.pre, %dec_label_pc_117e4.dec_label_pc_117a4_crit_edge ], [ %v2_117fc202, %dec_label_pc_117f0.preheader ]
  %v1_117fc210 = phi i8* [ %v1_117fc, %dec_label_pc_117e4.dec_label_pc_117a4_crit_edge ], [ %tmp2137, %dec_label_pc_117f0.preheader ]
  %stack_var_-112.1208 = phi i32 [ %stack_var_-112.0, %dec_label_pc_117e4.dec_label_pc_117a4_crit_edge ], [ 0, %dec_label_pc_117f0.preheader ]
  %storemerge72207 = phi i32 [ %v1_117e8, %dec_label_pc_117e4.dec_label_pc_117a4_crit_edge ], [ 0, %dec_label_pc_117f0.preheader ]
  %v2_117b4 = icmp ult i8 %v2_117b0, 13
  %v3_117b4 = icmp ne i1 %v2_117b4, true
  store i1 %v3_117b4, i1* %cpsr_c.global-to-local, align 1
  %v9_117b4 = icmp eq i8 %v2_117b0, 13
  store i1 %v9_117b4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_117b4, label %dec_label_pc_117e4, label %dec_label_pc_117bc

dec_label_pc_117bc:                               ; preds = %dec_label_pc_117a4
  %v1_117c0 = add i32 %stack_var_-112.1208, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_117d4 = load i8, i8* %v1_117fc210, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_117e0 = add i32 %v2_128d8, %stack_var_-112.1208
  %v4_117e0 = inttoptr i32 %v3_117e0 to i8*
  store i8 %v2_117d4, i8* %v4_117e0, align 1
  br label %dec_label_pc_117e4

dec_label_pc_117e4:                               ; preds = %dec_label_pc_117bc, %dec_label_pc_117a4
  %stack_var_-112.0 = phi i32 [ %stack_var_-112.1208, %dec_label_pc_117a4 ], [ %v1_117c0, %dec_label_pc_117bc ]
  %v1_117e8 = add i32 %storemerge72207, 1
  %v2_117f8 = add i32 %v1_117e8, %v2_11034
  %v1_117fc = inttoptr i32 %v2_117f8 to i8*
  %v2_117fc = load i8, i8* %v1_117fc, align 1
  %v2_11800 = icmp ult i8 %v2_117fc, 16
  %v3_11800 = icmp ne i1 %v2_11800, true
  store i1 %v3_11800, i1* %cpsr_c.global-to-local, align 1
  %v9_11800 = icmp eq i8 %v2_117fc, 16
  store i1 %v9_11800, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11800, label %dec_label_pc_11808, label %dec_label_pc_117e4.dec_label_pc_117a4_crit_edge

dec_label_pc_117e4.dec_label_pc_117a4_crit_edge:  ; preds = %dec_label_pc_117e4
  %v2_117b0.pre = load i8, i8* %v1_117fc, align 1
  br label %dec_label_pc_117a4

dec_label_pc_11808:                               ; preds = %dec_label_pc_117e4, %dec_label_pc_117f0.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_11814 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_11814, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_1186c

dec_label_pc_11828:                               ; preds = %dec_label_pc_11750, %dec_label_pc_11724
  %stack_var_-28.8 = phi i8* [ %tmp2137, %dec_label_pc_11724 ], [ %v4_1175c, %dec_label_pc_11750 ]
  %v2_1182c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_1182c, i32* %r0.global-to-local, align 4
  %v4_1183c = ptrtoint i8* %stack_var_-28.8 to i32
  %v1_11844 = sub i32 %v2_12938, %v4_1183c
  store i32 %v4_1183c, i32* %r1.global-to-local, align 4
  %v2_11850 = bitcast i8* %stack_var_-28.8 to i32*
  %v4_11850 = call i32 @read(i32 %v2_1182c, i32* %v2_11850, i32 %v1_11844)
  store i32 %v4_11850, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_1185c = icmp eq i32 %v4_11850, 0
  store i1 %v7_1185c, i1* %cpsr_z.global-to-local, align 1
  %v8_11860 = icmp sgt i32 %v4_11850, 0
  br i1 %v8_11860, label %dec_label_pc_11750, label %dec_label_pc_1186c

dec_label_pc_1186c:                               ; preds = %dec_label_pc_11828, %dec_label_pc_11774, %dec_label_pc_11808
  %stack_var_-28.9 = phi i8* [ %v4_1175c, %dec_label_pc_11774 ], [ %v4_1175c, %dec_label_pc_11808 ], [ %stack_var_-28.8, %dec_label_pc_11828 ]
  %stack_var_-24.3 = phi i32 [ 6, %dec_label_pc_11774 ], [ 7, %dec_label_pc_11808 ], [ 6, %dec_label_pc_11828 ]
  store i8 0, i8* %stack_var_-28.9, align 1
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_1187c:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15c18.186 to i32), i32* %r0.global-to-local, align 4
  %v3_11880 = call i32 @puts(i8* bitcast (i8** @global_var_15c18.186 to i8*))
  %v2_11888 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15c34.188 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11888, i32* %r0.global-to-local, align 4
  %v4_11898 = call i32 @write(i32 %v2_11888, i32* bitcast ([6 x i8]* @global_var_15c34.188 to i32*), i32 5)
  store i32 %v4_11898, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11954

dec_label_pc_118a8:                               ; preds = %dec_label_pc_11954
  %v2_118b0 = add i32 %v4_1197c, %v4_11968
  %v4_118b4 = inttoptr i32 %v2_118b0 to i8*
  %v1_118bc = add i32 %v2_118b0, -1
  %v1_118c0 = inttoptr i32 %v1_118bc to i8*
  %v2_118c0 = load i8, i8* %v1_118c0, align 1
  %v2_118c4 = icmp ult i8 %v2_118c0, 62
  %v3_118c4 = icmp ne i1 %v2_118c4, true
  store i1 %v3_118c4, i1* %cpsr_c.global-to-local, align 1
  %v9_118c4 = icmp eq i8 %v2_118c0, 62
  store i1 %v9_118c4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_118c4, label %dec_label_pc_1192c.preheader, label %dec_label_pc_11954

dec_label_pc_1192c.preheader:                     ; preds = %dec_label_pc_118a8
  %v2_11938179 = load i8, i8* %tmp2137, align 4
  %v2_1193c181 = icmp ult i8 %v2_11938179, 16
  %v3_1193c182 = icmp ne i1 %v2_1193c181, true
  store i1 %v3_1193c182, i1* %cpsr_c.global-to-local, align 1
  %v9_1193c183 = icmp eq i8 %v2_11938179, 16
  store i1 %v9_1193c183, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1193c183, label %dec_label_pc_11990, label %dec_label_pc_118e0

dec_label_pc_118e0:                               ; preds = %dec_label_pc_1192c.preheader, %dec_label_pc_11920.dec_label_pc_118e0_crit_edge
  %v2_118ec = phi i8 [ %v2_118ec.pre, %dec_label_pc_11920.dec_label_pc_118e0_crit_edge ], [ %v2_11938179, %dec_label_pc_1192c.preheader ]
  %v1_11938187 = phi i8* [ %v1_11938, %dec_label_pc_11920.dec_label_pc_118e0_crit_edge ], [ %tmp2137, %dec_label_pc_1192c.preheader ]
  %stack_var_-120.1185 = phi i32 [ %stack_var_-120.0, %dec_label_pc_11920.dec_label_pc_118e0_crit_edge ], [ 0, %dec_label_pc_1192c.preheader ]
  %storemerge71184 = phi i32 [ %v1_11924, %dec_label_pc_11920.dec_label_pc_118e0_crit_edge ], [ 0, %dec_label_pc_1192c.preheader ]
  %v2_118f0 = icmp ult i8 %v2_118ec, 13
  %v3_118f0 = icmp ne i1 %v2_118f0, true
  store i1 %v3_118f0, i1* %cpsr_c.global-to-local, align 1
  %v9_118f0 = icmp eq i8 %v2_118ec, 13
  store i1 %v9_118f0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_118f0, label %dec_label_pc_11920, label %dec_label_pc_118f8

dec_label_pc_118f8:                               ; preds = %dec_label_pc_118e0
  %v1_118fc = add i32 %stack_var_-120.1185, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_11910 = load i8, i8* %v1_11938187, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_1191c = add i32 %v2_128d8, %stack_var_-120.1185
  %v4_1191c = inttoptr i32 %v3_1191c to i8*
  store i8 %v2_11910, i8* %v4_1191c, align 1
  br label %dec_label_pc_11920

dec_label_pc_11920:                               ; preds = %dec_label_pc_118f8, %dec_label_pc_118e0
  %stack_var_-120.0 = phi i32 [ %stack_var_-120.1185, %dec_label_pc_118e0 ], [ %v1_118fc, %dec_label_pc_118f8 ]
  %v1_11924 = add i32 %storemerge71184, 1
  %v2_11934 = add i32 %v1_11924, %v2_11034
  %v1_11938 = inttoptr i32 %v2_11934 to i8*
  %v2_11938 = load i8, i8* %v1_11938, align 1
  %v2_1193c = icmp ult i8 %v2_11938, 16
  %v3_1193c = icmp ne i1 %v2_1193c, true
  store i1 %v3_1193c, i1* %cpsr_c.global-to-local, align 1
  %v9_1193c = icmp eq i8 %v2_11938, 16
  store i1 %v9_1193c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1193c, label %dec_label_pc_11990, label %dec_label_pc_11920.dec_label_pc_118e0_crit_edge

dec_label_pc_11920.dec_label_pc_118e0_crit_edge:  ; preds = %dec_label_pc_11920
  %v2_118ec.pre = load i8, i8* %v1_11938, align 1
  br label %dec_label_pc_118e0

dec_label_pc_11954:                               ; preds = %dec_label_pc_118a8, %dec_label_pc_1187c
  %stack_var_-28.10 = phi i8* [ %tmp2137, %dec_label_pc_1187c ], [ %v4_118b4, %dec_label_pc_118a8 ]
  %v2_11958 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_11958, i32* %r0.global-to-local, align 4
  %v4_11968 = ptrtoint i8* %stack_var_-28.10 to i32
  %v1_11970 = sub i32 %v2_12938, %v4_11968
  store i32 %v4_11968, i32* %r1.global-to-local, align 4
  %v2_1197c = bitcast i8* %stack_var_-28.10 to i32*
  %v4_1197c = call i32 @read(i32 %v2_11958, i32* %v2_1197c, i32 %v1_11970)
  store i32 %v4_1197c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11988 = icmp eq i32 %v4_1197c, 0
  store i1 %v7_11988, i1* %cpsr_z.global-to-local, align 1
  %v8_1198c = icmp sgt i32 %v4_1197c, 0
  br i1 %v8_1198c, label %dec_label_pc_118a8, label %dec_label_pc_11990

dec_label_pc_11990:                               ; preds = %dec_label_pc_11954, %dec_label_pc_1192c.preheader, %dec_label_pc_11920
  %stack_var_-28.11 = phi i8* [ %v4_118b4, %dec_label_pc_11920 ], [ %v4_118b4, %dec_label_pc_1192c.preheader ], [ %stack_var_-28.10, %dec_label_pc_11954 ]
  %stack_var_-24.4 = phi i32 [ 8, %dec_label_pc_11920 ], [ 8, %dec_label_pc_1192c.preheader ], [ 7, %dec_label_pc_11954 ]
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_1199c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i8 0, i8* %stack_var_-28.11, align 1
  store i32 ptrtoint ([3 x i8]* @global_var_15c3c.190 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_119b8 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15c3c.190, i32 0, i32 0))
  %v8_119b8 = ptrtoint i8* %v6_119b8 to i32
  store i32 %v8_119b8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_119c0 = icmp eq i8* %v6_119b8, null
  store i1 %v7_119c0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_119c0, label %dec_label_pc_12d10.backedge.thread, label %dec_label_pc_119c8

dec_label_pc_119c8:                               ; preds = %dec_label_pc_11990
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_119cc, i32* %r0.global-to-local, align 4
  %v9_119e0 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2138, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_119e8, i32* %r0.global-to-local, align 4
  %v9_119fc = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2139, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11a04, i32* %r0.global-to-local, align 4
  %v9_11a18 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2140, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11a20, i32* %r0.global-to-local, align 4
  %v9_11a30 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2141, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  %v3_11a34 = load i8, i8* %stack_var_-597, align 1
  %v4_11a34 = zext i8 %v3_11a34 to i32
  store i32 %v4_11a34, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c48.194 to i32), i32* %r0.global-to-local, align 4
  %v3_11a48 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c48.194 to i8*))
  store i32 %v3_11a48, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_11b9c

dec_label_pc_11b9c:                               ; preds = %dec_label_pc_119c8, %dec_label_pc_11c20
  %storemerge65190 = phi i32 [ 7, %dec_label_pc_119c8 ], [ %v2_11ba4, %dec_label_pc_11c20 ]
  %stack_var_-40.1189 = phi i32 [ %stack_var_-40.33267.ph, %dec_label_pc_119c8 ], [ %stack_var_-40.0, %dec_label_pc_11c20 ]
  %stack_var_-44.0188 = phi i32 [ %stack_var_-44.17266.ph, %dec_label_pc_119c8 ], [ %v1_11c24, %dec_label_pc_11c20 ]
  %v2_11ba4 = add nsw i32 %storemerge65190, -1
  %v6_11ba444 = lshr i32 %v4_11a34, %storemerge65190
  %v1_11ba8 = urem i32 %v6_11ba444, 2
  %v2_11bbc = icmp eq i32 %v1_11ba8, 0
  %v3_11bbc = icmp ne i1 %v2_11bbc, true
  store i1 %v3_11bbc, i1* %cpsr_c.global-to-local, align 1
  %v9_11bbc = icmp ne i32 %v1_11ba8, 0
  store i1 %v9_11bbc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11bbc, label %dec_label_pc_11bc4, label %dec_label_pc_11c20

dec_label_pc_11bc4:                               ; preds = %dec_label_pc_11b9c
  %v2_11bc8 = icmp ult i32 %stack_var_-44.0188, 3
  %v3_11bc8 = icmp ne i1 %v2_11bc8, true
  store i1 %v3_11bc8, i1* %cpsr_c.global-to-local, align 1
  %v9_11bc8 = icmp eq i32 %stack_var_-44.0188, 3
  store i1 %v9_11bc8, i1* %cpsr_z.global-to-local, align 1
  %v7_11bcc = icmp slt i32 %stack_var_-44.0188, 4
  br i1 %v7_11bcc, label %dec_label_pc_11c20, label %dec_label_pc_11bd0

dec_label_pc_11bd0:                               ; preds = %dec_label_pc_11bc4
  %v2_11bd4 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11bd4 = ptrtoint %_IO_FILE* %v2_11bd4 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_11bd4, i32* %r0.global-to-local, align 4
  %v7_11be4 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_11bd4, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.0188)
  %v2_11bec = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11bec = ptrtoint %_IO_FILE* %v2_11bec to i32
  store i32 %v3_11bec, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_11bf8 = call i32 @fputc(i32 44, %_IO_FILE* %v2_11bec)
  store i32 %stack_var_-44.0188, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_11c04 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %stack_var_-40.1189, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c9c.200 to i32), i32* %r0.global-to-local, align 4
  %v3_11c10 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c9c.200 to i8*))
  store i32 %v3_11c10, i32* %r0.global-to-local, align 4
  %v1_11c18 = add i32 %stack_var_-40.1189, 1
  br label %dec_label_pc_11c20

dec_label_pc_11c20:                               ; preds = %dec_label_pc_11b9c, %dec_label_pc_11bd0, %dec_label_pc_11bc4
  %stack_var_-40.0 = phi i32 [ %stack_var_-40.1189, %dec_label_pc_11bc4 ], [ %v1_11c18, %dec_label_pc_11bd0 ], [ %stack_var_-40.1189, %dec_label_pc_11b9c ]
  %v1_11c24 = add i32 %stack_var_-44.0188, 1
  store i32 %v1_11ba8, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_11c34 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_11c34, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_11c48 = icmp slt i32 %storemerge65190, 1
  %v7_11c48 = icmp eq i32 %v2_11ba4, 0
  store i1 %v7_11c48, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_11c48, label %dec_label_pc_11c50, label %dec_label_pc_11b9c

dec_label_pc_11c50:                               ; preds = %dec_label_pc_11c20
  %tmp2149 = add i32 %stack_var_-44.17266.ph, 8
  %v3_11c50 = load i8, i8* %stack_var_-598, align 1
  %v4_11c50 = zext i8 %v3_11c50 to i32
  store i32 %v4_11c50, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cbc.204 to i32), i32* %r0.global-to-local, align 4
  %v3_11c64 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cbc.204 to i8*))
  store i32 %v3_11c64, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_11c74

dec_label_pc_11c74:                               ; preds = %dec_label_pc_11c50, %dec_label_pc_11ce0
  %storemerge66193 = phi i32 [ 7, %dec_label_pc_11c50 ], [ %v2_11c7c, %dec_label_pc_11ce0 ]
  %stack_var_-40.3192 = phi i32 [ %stack_var_-40.0, %dec_label_pc_11c50 ], [ %stack_var_-40.2, %dec_label_pc_11ce0 ]
  %stack_var_-44.1191 = phi i32 [ %tmp2149, %dec_label_pc_11c50 ], [ %v1_11ce4, %dec_label_pc_11ce0 ]
  %v2_11c7c = add nsw i32 %storemerge66193, -1
  %v6_11c7c42 = lshr i32 %v4_11c50, %storemerge66193
  %v1_11c80 = urem i32 %v6_11c7c42, 2
  %v2_11c94 = icmp eq i32 %v1_11c80, 0
  %v3_11c94 = icmp ne i1 %v2_11c94, true
  store i1 %v3_11c94, i1* %cpsr_c.global-to-local, align 1
  %v9_11c94 = icmp ne i32 %v1_11c80, 0
  store i1 %v9_11c94, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11c94, label %dec_label_pc_11c9c, label %dec_label_pc_11ce0

dec_label_pc_11c9c:                               ; preds = %dec_label_pc_11c74
  %v2_11ca0 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11ca0 = ptrtoint %_IO_FILE* %v2_11ca0 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_11ca0, i32* %r0.global-to-local, align 4
  %v7_11cb0 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_11ca0, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.1191)
  %v2_11cb8 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11cb8 = ptrtoint %_IO_FILE* %v2_11cb8 to i32
  store i32 %v3_11cb8, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_11cc4 = call i32 @fputc(i32 44, %_IO_FILE* %v2_11cb8)
  store i32 %stack_var_-44.1191, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_11cd0 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_11cd0, i32* %r0.global-to-local, align 4
  %v1_11cd8 = add i32 %stack_var_-40.3192, 1
  br label %dec_label_pc_11ce0

dec_label_pc_11ce0:                               ; preds = %dec_label_pc_11c74, %dec_label_pc_11c9c
  %stack_var_-40.2 = phi i32 [ %v1_11cd8, %dec_label_pc_11c9c ], [ %stack_var_-40.3192, %dec_label_pc_11c74 ]
  %v1_11ce4 = add i32 %stack_var_-44.1191, 1
  store i32 %v1_11c80, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_11cf4 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_11cf4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_11d08 = icmp slt i32 %storemerge66193, 1
  %v7_11d08 = icmp eq i32 %v2_11c7c, 0
  store i1 %v7_11d08, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_11d08, label %dec_label_pc_11d10, label %dec_label_pc_11c74

dec_label_pc_11d10:                               ; preds = %dec_label_pc_11ce0
  %tmp2150 = add i32 %stack_var_-44.17266.ph, 16
  %v3_11d10 = load i8, i8* %stack_var_-599, align 1
  %v4_11d10 = zext i8 %v3_11d10 to i32
  store i32 %v4_11d10, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cdc.206 to i32), i32* %r0.global-to-local, align 4
  %v3_11d24 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cdc.206 to i8*))
  store i32 %v3_11d24, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_11d34

dec_label_pc_11d34:                               ; preds = %dec_label_pc_11d10, %dec_label_pc_11da8
  %storemerge67196 = phi i32 [ 7, %dec_label_pc_11d10 ], [ %v2_11d3c, %dec_label_pc_11da8 ]
  %stack_var_-40.5195 = phi i32 [ %stack_var_-40.2, %dec_label_pc_11d10 ], [ %stack_var_-40.4, %dec_label_pc_11da8 ]
  %stack_var_-44.2194 = phi i32 [ %tmp2150, %dec_label_pc_11d10 ], [ %v1_11dac, %dec_label_pc_11da8 ]
  %v2_11d3c = add nsw i32 %storemerge67196, -1
  %v6_11d3c40 = lshr i32 %v4_11d10, %storemerge67196
  %v1_11d40 = urem i32 %v6_11d3c40, 2
  %v2_11d5c = icmp eq i32 %v1_11d40, 0
  %v3_11d5c = icmp ne i1 %v2_11d5c, true
  store i1 %v3_11d5c, i1* %cpsr_c.global-to-local, align 1
  %v9_11d5c = icmp ne i32 %v1_11d40, 0
  store i1 %v9_11d5c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11d5c, label %dec_label_pc_11d64, label %dec_label_pc_11da8

dec_label_pc_11d64:                               ; preds = %dec_label_pc_11d34
  %v2_11d68 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11d68 = ptrtoint %_IO_FILE* %v2_11d68 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_11d68, i32* %r0.global-to-local, align 4
  %v7_11d78 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_11d68, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.2194)
  %v2_11d80 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11d80 = ptrtoint %_IO_FILE* %v2_11d80 to i32
  store i32 %v3_11d80, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_11d8c = call i32 @fputc(i32 44, %_IO_FILE* %v2_11d80)
  store i32 %stack_var_-44.2194, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_11d98 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_11d98, i32* %r0.global-to-local, align 4
  %v1_11da0 = add i32 %stack_var_-40.5195, 1
  br label %dec_label_pc_11da8

dec_label_pc_11da8:                               ; preds = %dec_label_pc_11d34, %dec_label_pc_11d64
  %stack_var_-40.4 = phi i32 [ %v1_11da0, %dec_label_pc_11d64 ], [ %stack_var_-40.5195, %dec_label_pc_11d34 ]
  %v1_11dac = add i32 %stack_var_-44.2194, 1
  store i32 %v1_11d40, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_11dbc = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_11dbc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_11dd0 = icmp slt i32 %storemerge67196, 1
  %v7_11dd0 = icmp eq i32 %v2_11d3c, 0
  store i1 %v7_11dd0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_11dd0, label %dec_label_pc_11dd8, label %dec_label_pc_11d34

dec_label_pc_11dd8:                               ; preds = %dec_label_pc_11da8
  %tmp2151 = add i32 %stack_var_-44.17266.ph, 24
  %v3_11dd8 = load i8, i8* %stack_var_-600, align 1
  %v4_11dd8 = zext i8 %v3_11dd8 to i32
  store i32 %v4_11dd8, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cfc.208 to i32), i32* %r0.global-to-local, align 4
  %v3_11dec = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cfc.208 to i8*))
  store i32 %v3_11dec, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_11dfc

dec_label_pc_11dfc:                               ; preds = %dec_label_pc_11dd8, %dec_label_pc_11e74
  %storemerge68199 = phi i32 [ 7, %dec_label_pc_11dd8 ], [ %v2_11e04, %dec_label_pc_11e74 ]
  %stack_var_-40.7198 = phi i32 [ %stack_var_-40.4, %dec_label_pc_11dd8 ], [ %stack_var_-40.6, %dec_label_pc_11e74 ]
  %stack_var_-44.3197 = phi i32 [ %tmp2151, %dec_label_pc_11dd8 ], [ %v1_11e78, %dec_label_pc_11e74 ]
  %v2_11e04 = add nsw i32 %storemerge68199, -1
  %v6_11e0438 = lshr i32 %v4_11dd8, %storemerge68199
  %v1_11e08 = urem i32 %v6_11e0438, 2
  %v2_11e1c = icmp eq i32 %v1_11e08, 0
  %v3_11e1c = icmp ne i1 %v2_11e1c, true
  store i1 %v3_11e1c, i1* %cpsr_c.global-to-local, align 1
  %v9_11e1c = icmp ne i32 %v1_11e08, 0
  store i1 %v9_11e1c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11e1c, label %dec_label_pc_11e24, label %dec_label_pc_11e74

dec_label_pc_11e24:                               ; preds = %dec_label_pc_11dfc
  %v2_11e28 = icmp ult i32 %stack_var_-44.3197, 28
  %v3_11e28 = icmp ne i1 %v2_11e28, true
  store i1 %v3_11e28, i1* %cpsr_c.global-to-local, align 1
  %v9_11e28 = icmp eq i32 %stack_var_-44.3197, 28
  store i1 %v9_11e28, i1* %cpsr_z.global-to-local, align 1
  %v8_11e2c = icmp sgt i32 %stack_var_-44.3197, 28
  br i1 %v8_11e2c, label %dec_label_pc_11e74, label %dec_label_pc_11e30

dec_label_pc_11e30:                               ; preds = %dec_label_pc_11e24
  %v2_11e34 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11e34 = ptrtoint %_IO_FILE* %v2_11e34 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_11e34, i32* %r0.global-to-local, align 4
  %v7_11e44 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_11e34, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.3197)
  %v2_11e4c = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_11e4c = ptrtoint %_IO_FILE* %v2_11e4c to i32
  store i32 %v3_11e4c, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_11e58 = call i32 @fputc(i32 44, %_IO_FILE* %v2_11e4c)
  store i32 %stack_var_-44.3197, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_11e64 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_11e64, i32* %r0.global-to-local, align 4
  %v1_11e6c = add i32 %stack_var_-40.7198, 1
  br label %dec_label_pc_11e74

dec_label_pc_11e74:                               ; preds = %dec_label_pc_11dfc, %dec_label_pc_11e30, %dec_label_pc_11e24
  %stack_var_-40.6 = phi i32 [ %stack_var_-40.7198, %dec_label_pc_11e24 ], [ %v1_11e6c, %dec_label_pc_11e30 ], [ %stack_var_-40.7198, %dec_label_pc_11dfc ]
  %v1_11e78 = add i32 %stack_var_-44.3197, 1
  store i32 %v1_11e08, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_11e88 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_11e88, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_11e9c = icmp slt i32 %storemerge68199, 1
  %v7_11e9c = icmp eq i32 %v2_11e04, 0
  store i1 %v7_11e9c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_11e9c, label %dec_label_pc_12d10.loopexit95, label %dec_label_pc_11dfc

dec_label_pc_11ea8:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15d1c.210 to i32), i32* %r0.global-to-local, align 4
  %v3_11eac = call i32 @puts(i8* bitcast (i8** @global_var_15d1c.210 to i8*))
  %v2_11eb4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15d38.212 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11eb4, i32* %r0.global-to-local, align 4
  %v4_11ec4 = call i32 @write(i32 %v2_11eb4, i32* bitcast ([6 x i8]* @global_var_15d38.212 to i32*), i32 5)
  store i32 %v4_11ec4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11f90

dec_label_pc_11ed4:                               ; preds = %dec_label_pc_11f90
  %v2_11edc = add i32 %v4_11fb8, %v4_11fa4
  %v4_11ee0 = inttoptr i32 %v2_11edc to i8*
  %v1_11ee8 = add i32 %v2_11edc, -1
  %v1_11eec = inttoptr i32 %v1_11ee8 to i8*
  %v2_11eec = load i8, i8* %v1_11eec, align 1
  %v2_11ef0 = icmp ult i8 %v2_11eec, 62
  %v3_11ef0 = icmp ne i1 %v2_11ef0, true
  store i1 %v3_11ef0, i1* %cpsr_c.global-to-local, align 1
  %v9_11ef0 = icmp eq i8 %v2_11eec, 62
  store i1 %v9_11ef0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11ef0, label %dec_label_pc_11f58.preheader, label %dec_label_pc_11f90

dec_label_pc_11f58.preheader:                     ; preds = %dec_label_pc_11ed4
  %v2_11f64156 = load i8, i8* %tmp2137, align 4
  %v2_11f68158 = icmp ult i8 %v2_11f64156, 16
  %v3_11f68159 = icmp ne i1 %v2_11f68158, true
  store i1 %v3_11f68159, i1* %cpsr_c.global-to-local, align 1
  %v9_11f68160 = icmp eq i8 %v2_11f64156, 16
  store i1 %v9_11f68160, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11f68160, label %dec_label_pc_11f70, label %dec_label_pc_11f0c

dec_label_pc_11f0c:                               ; preds = %dec_label_pc_11f58.preheader, %dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge
  %v2_11f18 = phi i8 [ %v2_11f18.pre, %dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge ], [ %v2_11f64156, %dec_label_pc_11f58.preheader ]
  %v1_11f64164 = phi i8* [ %v1_11f64, %dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge ], [ %tmp2137, %dec_label_pc_11f58.preheader ]
  %stack_var_-144.1162 = phi i32 [ %stack_var_-144.0, %dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge ], [ 0, %dec_label_pc_11f58.preheader ]
  %storemerge70161 = phi i32 [ %v1_11f50, %dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge ], [ 0, %dec_label_pc_11f58.preheader ]
  %v2_11f1c = icmp ult i8 %v2_11f18, 13
  %v3_11f1c = icmp ne i1 %v2_11f1c, true
  store i1 %v3_11f1c, i1* %cpsr_c.global-to-local, align 1
  %v9_11f1c = icmp eq i8 %v2_11f18, 13
  store i1 %v9_11f1c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11f1c, label %dec_label_pc_11f4c, label %dec_label_pc_11f24

dec_label_pc_11f24:                               ; preds = %dec_label_pc_11f0c
  %v1_11f28 = add i32 %stack_var_-144.1162, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_11f3c = load i8, i8* %v1_11f64164, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_11f48 = add i32 %v2_128d8, %stack_var_-144.1162
  %v4_11f48 = inttoptr i32 %v3_11f48 to i8*
  store i8 %v2_11f3c, i8* %v4_11f48, align 1
  br label %dec_label_pc_11f4c

dec_label_pc_11f4c:                               ; preds = %dec_label_pc_11f24, %dec_label_pc_11f0c
  %stack_var_-144.0 = phi i32 [ %stack_var_-144.1162, %dec_label_pc_11f0c ], [ %v1_11f28, %dec_label_pc_11f24 ]
  %v1_11f50 = add i32 %storemerge70161, 1
  %v2_11f60 = add i32 %v1_11f50, %v2_11034
  %v1_11f64 = inttoptr i32 %v2_11f60 to i8*
  %v2_11f64 = load i8, i8* %v1_11f64, align 1
  %v2_11f68 = icmp ult i8 %v2_11f64, 16
  %v3_11f68 = icmp ne i1 %v2_11f68, true
  store i1 %v3_11f68, i1* %cpsr_c.global-to-local, align 1
  %v9_11f68 = icmp eq i8 %v2_11f64, 16
  store i1 %v9_11f68, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_11f68, label %dec_label_pc_11f70, label %dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge

dec_label_pc_11f4c.dec_label_pc_11f0c_crit_edge:  ; preds = %dec_label_pc_11f4c
  %v2_11f18.pre = load i8, i8* %v1_11f64, align 1
  br label %dec_label_pc_11f0c

dec_label_pc_11f70:                               ; preds = %dec_label_pc_11f4c, %dec_label_pc_11f58.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_11f7c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_11f7c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_11fcc

dec_label_pc_11f90:                               ; preds = %dec_label_pc_11ed4, %dec_label_pc_11ea8
  %stack_var_-28.12 = phi i8* [ %tmp2137, %dec_label_pc_11ea8 ], [ %v4_11ee0, %dec_label_pc_11ed4 ]
  %v2_11f94 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_11f94, i32* %r0.global-to-local, align 4
  %v4_11fa4 = ptrtoint i8* %stack_var_-28.12 to i32
  %v1_11fac = sub i32 %v2_12938, %v4_11fa4
  store i32 %v4_11fa4, i32* %r1.global-to-local, align 4
  %v2_11fb8 = bitcast i8* %stack_var_-28.12 to i32*
  %v4_11fb8 = call i32 @read(i32 %v2_11f94, i32* %v2_11fb8, i32 %v1_11fac)
  store i32 %v4_11fb8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11fc4 = icmp eq i32 %v4_11fb8, 0
  store i1 %v7_11fc4, i1* %cpsr_z.global-to-local, align 1
  %v8_11fc8 = icmp sgt i32 %v4_11fb8, 0
  br i1 %v8_11fc8, label %dec_label_pc_11ed4, label %dec_label_pc_11fcc

dec_label_pc_11fcc:                               ; preds = %dec_label_pc_11f90, %dec_label_pc_11f70
  %stack_var_-28.13 = phi i8* [ %v4_11ee0, %dec_label_pc_11f70 ], [ %stack_var_-28.12, %dec_label_pc_11f90 ]
  %stack_var_-24.5 = phi i32 [ 9, %dec_label_pc_11f70 ], [ 8, %dec_label_pc_11f90 ]
  store i8 0, i8* %stack_var_-28.13, align 1
  store i32 ptrtoint ([3 x i8]* @global_var_15c3c.190 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_11fe4 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15c3c.190, i32 0, i32 0))
  %v8_11fe4 = ptrtoint i8* %v6_11fe4 to i32
  store i32 %v8_11fe4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_11fec = icmp eq i8* %v6_11fe4, null
  store i1 %v7_11fec, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_11fec, label %dec_label_pc_12d10.backedge.thread, label %dec_label_pc_11ff4

dec_label_pc_11ff4:                               ; preds = %dec_label_pc_11fcc
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_1200c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_12028 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_12044 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_1205c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  %v3_12060 = load i8, i8* %stack_var_-597, align 1
  %v4_12060 = zext i8 %v3_12060 to i32
  store i32 %v4_12060, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c48.194 to i32), i32* %r0.global-to-local, align 4
  %v3_12074 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c48.194 to i8*))
  store i32 %v3_12074, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12084

dec_label_pc_12084:                               ; preds = %dec_label_pc_11ff4, %dec_label_pc_120f0
  %storemerge61167 = phi i32 [ 7, %dec_label_pc_11ff4 ], [ %v2_1208c, %dec_label_pc_120f0 ]
  %stack_var_-40.9166 = phi i32 [ %stack_var_-40.33267.ph, %dec_label_pc_11ff4 ], [ %stack_var_-40.8, %dec_label_pc_120f0 ]
  %stack_var_-44.4165 = phi i32 [ %stack_var_-44.17266.ph, %dec_label_pc_11ff4 ], [ %v1_120f4, %dec_label_pc_120f0 ]
  %v2_1208c = add nsw i32 %storemerge61167, -1
  %v6_1208c36 = lshr i32 %v4_12060, %storemerge61167
  %v1_12090 = urem i32 %v6_1208c36, 2
  %v2_120a4 = icmp eq i32 %v1_12090, 0
  %v3_120a4 = icmp ne i1 %v2_120a4, true
  store i1 %v3_120a4, i1* %cpsr_c.global-to-local, align 1
  %v9_120a4 = icmp ne i32 %v1_12090, 0
  store i1 %v9_120a4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_120a4, label %dec_label_pc_120ac, label %dec_label_pc_120f0

dec_label_pc_120ac:                               ; preds = %dec_label_pc_12084
  %v2_120b0 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_120b0 = ptrtoint %_IO_FILE* %v2_120b0 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_120b0, i32* %r0.global-to-local, align 4
  %v7_120c0 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_120b0, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.4165)
  %v2_120c8 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_120c8 = ptrtoint %_IO_FILE* %v2_120c8 to i32
  store i32 %v3_120c8, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_120d4 = call i32 @fputc(i32 44, %_IO_FILE* %v2_120c8)
  store i32 %stack_var_-44.4165, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_120e0 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_120e0, i32* %r0.global-to-local, align 4
  %v1_120e8 = add i32 %stack_var_-40.9166, 1
  br label %dec_label_pc_120f0

dec_label_pc_120f0:                               ; preds = %dec_label_pc_12084, %dec_label_pc_120ac
  %stack_var_-40.8 = phi i32 [ %v1_120e8, %dec_label_pc_120ac ], [ %stack_var_-40.9166, %dec_label_pc_12084 ]
  %v1_120f4 = add i32 %stack_var_-44.4165, 1
  store i32 %v1_12090, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12104 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12104, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12118 = icmp slt i32 %storemerge61167, 1
  %v7_12118 = icmp eq i32 %v2_1208c, 0
  store i1 %v7_12118, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12118, label %dec_label_pc_12120, label %dec_label_pc_12084

dec_label_pc_12120:                               ; preds = %dec_label_pc_120f0
  %tmp2153 = add i32 %stack_var_-44.17266.ph, 8
  %v3_12120 = load i8, i8* %stack_var_-598, align 1
  %v4_12120 = zext i8 %v3_12120 to i32
  store i32 %v4_12120, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cbc.204 to i32), i32* %r0.global-to-local, align 4
  %v3_12134 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cbc.204 to i8*))
  store i32 %v3_12134, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12144

dec_label_pc_12144:                               ; preds = %dec_label_pc_12120, %dec_label_pc_121b0
  %storemerge62170 = phi i32 [ 7, %dec_label_pc_12120 ], [ %v2_1214c, %dec_label_pc_121b0 ]
  %stack_var_-40.11169 = phi i32 [ %stack_var_-40.8, %dec_label_pc_12120 ], [ %stack_var_-40.10, %dec_label_pc_121b0 ]
  %stack_var_-44.5168 = phi i32 [ %tmp2153, %dec_label_pc_12120 ], [ %v1_121b4, %dec_label_pc_121b0 ]
  %v2_1214c = add nsw i32 %storemerge62170, -1
  %v6_1214c34 = lshr i32 %v4_12120, %storemerge62170
  %v1_12150 = urem i32 %v6_1214c34, 2
  %v2_12164 = icmp eq i32 %v1_12150, 0
  %v3_12164 = icmp ne i1 %v2_12164, true
  store i1 %v3_12164, i1* %cpsr_c.global-to-local, align 1
  %v9_12164 = icmp ne i32 %v1_12150, 0
  store i1 %v9_12164, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12164, label %dec_label_pc_1216c, label %dec_label_pc_121b0

dec_label_pc_1216c:                               ; preds = %dec_label_pc_12144
  %v2_12170 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12170 = ptrtoint %_IO_FILE* %v2_12170 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12170, i32* %r0.global-to-local, align 4
  %v7_12180 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12170, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.5168)
  %v2_12188 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12188 = ptrtoint %_IO_FILE* %v2_12188 to i32
  store i32 %v3_12188, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12194 = call i32 @fputc(i32 44, %_IO_FILE* %v2_12188)
  store i32 %stack_var_-44.5168, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_121a0 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_121a0, i32* %r0.global-to-local, align 4
  %v1_121a8 = add i32 %stack_var_-40.11169, 1
  br label %dec_label_pc_121b0

dec_label_pc_121b0:                               ; preds = %dec_label_pc_12144, %dec_label_pc_1216c
  %stack_var_-40.10 = phi i32 [ %v1_121a8, %dec_label_pc_1216c ], [ %stack_var_-40.11169, %dec_label_pc_12144 ]
  %v1_121b4 = add i32 %stack_var_-44.5168, 1
  store i32 %v1_12150, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_121c4 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_121c4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_121d8 = icmp slt i32 %storemerge62170, 1
  %v7_121d8 = icmp eq i32 %v2_1214c, 0
  store i1 %v7_121d8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_121d8, label %dec_label_pc_121e0, label %dec_label_pc_12144

dec_label_pc_121e0:                               ; preds = %dec_label_pc_121b0
  %tmp2154 = add i32 %stack_var_-44.17266.ph, 16
  %v3_121e0 = load i8, i8* %stack_var_-599, align 1
  %v4_121e0 = zext i8 %v3_121e0 to i32
  store i32 %v4_121e0, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cdc.206 to i32), i32* %r0.global-to-local, align 4
  %v3_121f4 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cdc.206 to i8*))
  store i32 %v3_121f4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12204

dec_label_pc_12204:                               ; preds = %dec_label_pc_121e0, %dec_label_pc_12278
  %storemerge63173 = phi i32 [ 7, %dec_label_pc_121e0 ], [ %v2_1220c, %dec_label_pc_12278 ]
  %stack_var_-40.13172 = phi i32 [ %stack_var_-40.10, %dec_label_pc_121e0 ], [ %stack_var_-40.12, %dec_label_pc_12278 ]
  %stack_var_-44.6171 = phi i32 [ %tmp2154, %dec_label_pc_121e0 ], [ %v1_1227c, %dec_label_pc_12278 ]
  %v2_1220c = add nsw i32 %storemerge63173, -1
  %v6_1220c32 = lshr i32 %v4_121e0, %storemerge63173
  %v1_12210 = urem i32 %v6_1220c32, 2
  %v2_1222c = icmp eq i32 %v1_12210, 0
  %v3_1222c = icmp ne i1 %v2_1222c, true
  store i1 %v3_1222c, i1* %cpsr_c.global-to-local, align 1
  %v9_1222c = icmp ne i32 %v1_12210, 0
  store i1 %v9_1222c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1222c, label %dec_label_pc_12234, label %dec_label_pc_12278

dec_label_pc_12234:                               ; preds = %dec_label_pc_12204
  %v2_12238 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12238 = ptrtoint %_IO_FILE* %v2_12238 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12238, i32* %r0.global-to-local, align 4
  %v7_12248 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12238, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.6171)
  %v2_12250 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12250 = ptrtoint %_IO_FILE* %v2_12250 to i32
  store i32 %v3_12250, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_1225c = call i32 @fputc(i32 44, %_IO_FILE* %v2_12250)
  store i32 %stack_var_-44.6171, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12268 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12268, i32* %r0.global-to-local, align 4
  %v1_12270 = add i32 %stack_var_-40.13172, 1
  br label %dec_label_pc_12278

dec_label_pc_12278:                               ; preds = %dec_label_pc_12204, %dec_label_pc_12234
  %stack_var_-40.12 = phi i32 [ %v1_12270, %dec_label_pc_12234 ], [ %stack_var_-40.13172, %dec_label_pc_12204 ]
  %v1_1227c = add i32 %stack_var_-44.6171, 1
  store i32 %v1_12210, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_1228c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_1228c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_122a0 = icmp slt i32 %storemerge63173, 1
  %v7_122a0 = icmp eq i32 %v2_1220c, 0
  store i1 %v7_122a0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_122a0, label %dec_label_pc_122a8, label %dec_label_pc_12204

dec_label_pc_122a8:                               ; preds = %dec_label_pc_12278
  %tmp2155 = add i32 %stack_var_-44.17266.ph, 24
  %v3_122a8 = load i8, i8* %stack_var_-600, align 1
  %v4_122a8 = zext i8 %v3_122a8 to i32
  store i32 %v4_122a8, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cfc.208 to i32), i32* %r0.global-to-local, align 4
  %v3_122bc = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cfc.208 to i8*))
  store i32 %v3_122bc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_122cc

dec_label_pc_122cc:                               ; preds = %dec_label_pc_122a8, %dec_label_pc_12338
  %storemerge64176 = phi i32 [ 7, %dec_label_pc_122a8 ], [ %v2_122d4, %dec_label_pc_12338 ]
  %stack_var_-40.15175 = phi i32 [ %stack_var_-40.12, %dec_label_pc_122a8 ], [ %stack_var_-40.14, %dec_label_pc_12338 ]
  %stack_var_-44.7174 = phi i32 [ %tmp2155, %dec_label_pc_122a8 ], [ %v1_1233c, %dec_label_pc_12338 ]
  %v2_122d4 = add nsw i32 %storemerge64176, -1
  %v6_122d430 = lshr i32 %v4_122a8, %storemerge64176
  %v1_122d8 = urem i32 %v6_122d430, 2
  %v2_122ec = icmp eq i32 %v1_122d8, 0
  %v3_122ec = icmp ne i1 %v2_122ec, true
  store i1 %v3_122ec, i1* %cpsr_c.global-to-local, align 1
  %v9_122ec = icmp ne i32 %v1_122d8, 0
  store i1 %v9_122ec, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_122ec, label %dec_label_pc_122f4, label %dec_label_pc_12338

dec_label_pc_122f4:                               ; preds = %dec_label_pc_122cc
  %v2_122f8 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_122f8 = ptrtoint %_IO_FILE* %v2_122f8 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_122f8, i32* %r0.global-to-local, align 4
  %v7_12308 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_122f8, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.7174)
  %v2_12310 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12310 = ptrtoint %_IO_FILE* %v2_12310 to i32
  store i32 %v3_12310, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_1231c = call i32 @fputc(i32 44, %_IO_FILE* %v2_12310)
  store i32 %stack_var_-44.7174, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12328 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12328, i32* %r0.global-to-local, align 4
  %v1_12330 = add i32 %stack_var_-40.15175, 1
  br label %dec_label_pc_12338

dec_label_pc_12338:                               ; preds = %dec_label_pc_122cc, %dec_label_pc_122f4
  %stack_var_-40.14 = phi i32 [ %v1_12330, %dec_label_pc_122f4 ], [ %stack_var_-40.15175, %dec_label_pc_122cc ]
  %v1_1233c = add i32 %stack_var_-44.7174, 1
  store i32 %v1_122d8, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_1234c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_1234c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12360 = icmp slt i32 %storemerge64176, 1
  %v7_12360 = icmp eq i32 %v2_122d4, 0
  store i1 %v7_12360, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12360, label %dec_label_pc_12d10.loopexit96, label %dec_label_pc_122cc

dec_label_pc_1236c:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15d40.214 to i32), i32* %r0.global-to-local, align 4
  %v3_12370 = call i32 @puts(i8* bitcast (i8** @global_var_15d40.214 to i8*))
  %v2_12378 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15d5c.216 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12378, i32* %r0.global-to-local, align 4
  %v4_12388 = call i32 @write(i32 %v2_12378, i32* bitcast ([6 x i8]* @global_var_15d5c.216 to i32*), i32 5)
  store i32 %v4_12388, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12454

dec_label_pc_12398:                               ; preds = %dec_label_pc_12454
  %v2_123a0 = add i32 %v4_1247c, %v4_12468
  %v4_123a4 = inttoptr i32 %v2_123a0 to i8*
  %v1_123ac = add i32 %v2_123a0, -1
  %v1_123b0 = inttoptr i32 %v1_123ac to i8*
  %v2_123b0 = load i8, i8* %v1_123b0, align 1
  %v2_123b4 = icmp ult i8 %v2_123b0, 62
  %v3_123b4 = icmp ne i1 %v2_123b4, true
  store i1 %v3_123b4, i1* %cpsr_c.global-to-local, align 1
  %v9_123b4 = icmp eq i8 %v2_123b0, 62
  store i1 %v9_123b4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_123b4, label %dec_label_pc_1241c.preheader, label %dec_label_pc_12454

dec_label_pc_1241c.preheader:                     ; preds = %dec_label_pc_12398
  %v2_12428133 = load i8, i8* %tmp2137, align 4
  %v2_1242c135 = icmp ult i8 %v2_12428133, 16
  %v3_1242c136 = icmp ne i1 %v2_1242c135, true
  store i1 %v3_1242c136, i1* %cpsr_c.global-to-local, align 1
  %v9_1242c137 = icmp eq i8 %v2_12428133, 16
  store i1 %v9_1242c137, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1242c137, label %dec_label_pc_12434, label %dec_label_pc_123d0

dec_label_pc_123d0:                               ; preds = %dec_label_pc_1241c.preheader, %dec_label_pc_12410.dec_label_pc_123d0_crit_edge
  %v2_123dc = phi i8 [ %v2_123dc.pre, %dec_label_pc_12410.dec_label_pc_123d0_crit_edge ], [ %v2_12428133, %dec_label_pc_1241c.preheader ]
  %v1_12428141 = phi i8* [ %v1_12428, %dec_label_pc_12410.dec_label_pc_123d0_crit_edge ], [ %tmp2137, %dec_label_pc_1241c.preheader ]
  %stack_var_-168.1139 = phi i32 [ %stack_var_-168.0, %dec_label_pc_12410.dec_label_pc_123d0_crit_edge ], [ 0, %dec_label_pc_1241c.preheader ]
  %storemerge69138 = phi i32 [ %v1_12414, %dec_label_pc_12410.dec_label_pc_123d0_crit_edge ], [ 0, %dec_label_pc_1241c.preheader ]
  %v2_123e0 = icmp ult i8 %v2_123dc, 13
  %v3_123e0 = icmp ne i1 %v2_123e0, true
  store i1 %v3_123e0, i1* %cpsr_c.global-to-local, align 1
  %v9_123e0 = icmp eq i8 %v2_123dc, 13
  store i1 %v9_123e0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_123e0, label %dec_label_pc_12410, label %dec_label_pc_123e8

dec_label_pc_123e8:                               ; preds = %dec_label_pc_123d0
  %v1_123ec = add i32 %stack_var_-168.1139, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_12400 = load i8, i8* %v1_12428141, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_1240c = add i32 %v2_128d8, %stack_var_-168.1139
  %v4_1240c = inttoptr i32 %v3_1240c to i8*
  store i8 %v2_12400, i8* %v4_1240c, align 1
  br label %dec_label_pc_12410

dec_label_pc_12410:                               ; preds = %dec_label_pc_123e8, %dec_label_pc_123d0
  %stack_var_-168.0 = phi i32 [ %stack_var_-168.1139, %dec_label_pc_123d0 ], [ %v1_123ec, %dec_label_pc_123e8 ]
  %v1_12414 = add i32 %storemerge69138, 1
  %v2_12424 = add i32 %v1_12414, %v2_11034
  %v1_12428 = inttoptr i32 %v2_12424 to i8*
  %v2_12428 = load i8, i8* %v1_12428, align 1
  %v2_1242c = icmp ult i8 %v2_12428, 16
  %v3_1242c = icmp ne i1 %v2_1242c, true
  store i1 %v3_1242c, i1* %cpsr_c.global-to-local, align 1
  %v9_1242c = icmp eq i8 %v2_12428, 16
  store i1 %v9_1242c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1242c, label %dec_label_pc_12434, label %dec_label_pc_12410.dec_label_pc_123d0_crit_edge

dec_label_pc_12410.dec_label_pc_123d0_crit_edge:  ; preds = %dec_label_pc_12410
  %v2_123dc.pre = load i8, i8* %v1_12428, align 1
  br label %dec_label_pc_123d0

dec_label_pc_12434:                               ; preds = %dec_label_pc_12410, %dec_label_pc_1241c.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_12440 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_12440, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12490

dec_label_pc_12454:                               ; preds = %dec_label_pc_12398, %dec_label_pc_1236c
  %stack_var_-28.14 = phi i8* [ %tmp2137, %dec_label_pc_1236c ], [ %v4_123a4, %dec_label_pc_12398 ]
  %v2_12458 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_12458, i32* %r0.global-to-local, align 4
  %v4_12468 = ptrtoint i8* %stack_var_-28.14 to i32
  %v1_12470 = sub i32 %v2_12938, %v4_12468
  store i32 %v4_12468, i32* %r1.global-to-local, align 4
  %v2_1247c = bitcast i8* %stack_var_-28.14 to i32*
  %v4_1247c = call i32 @read(i32 %v2_12458, i32* %v2_1247c, i32 %v1_12470)
  store i32 %v4_1247c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_12488 = icmp eq i32 %v4_1247c, 0
  store i1 %v7_12488, i1* %cpsr_z.global-to-local, align 1
  %v8_1248c = icmp sgt i32 %v4_1247c, 0
  br i1 %v8_1248c, label %dec_label_pc_12398, label %dec_label_pc_12490

dec_label_pc_12490:                               ; preds = %dec_label_pc_12454, %dec_label_pc_12434
  %stack_var_-28.15 = phi i8* [ %v4_123a4, %dec_label_pc_12434 ], [ %stack_var_-28.14, %dec_label_pc_12454 ]
  %stack_var_-24.6 = phi i32 [ 10, %dec_label_pc_12434 ], [ 9, %dec_label_pc_12454 ]
  store i8 0, i8* %stack_var_-28.15, align 1
  store i32 ptrtoint ([3 x i8]* @global_var_15c3c.190 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_124a8 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15c3c.190, i32 0, i32 0))
  %v8_124a8 = ptrtoint i8* %v6_124a8 to i32
  store i32 %v8_124a8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_124b0 = icmp eq i8* %v6_124a8, null
  store i1 %v7_124b0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_124b0, label %dec_label_pc_12d10.backedge.thread, label %dec_label_pc_124b8

dec_label_pc_124b8:                               ; preds = %dec_label_pc_12490
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_124d0 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_124ec = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_12508 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_12520 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  %v3_12524 = load i8, i8* %stack_var_-597, align 1
  %v4_12524 = zext i8 %v3_12524 to i32
  store i32 %v4_12524, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c48.194 to i32), i32* %r0.global-to-local, align 4
  %v3_12538 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c48.194 to i8*))
  store i32 %v3_12538, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12548

dec_label_pc_12548:                               ; preds = %dec_label_pc_124b8, %dec_label_pc_125b4
  %storemerge57144 = phi i32 [ 7, %dec_label_pc_124b8 ], [ %v2_12550, %dec_label_pc_125b4 ]
  %stack_var_-40.17143 = phi i32 [ %stack_var_-40.33267.ph, %dec_label_pc_124b8 ], [ %stack_var_-40.16, %dec_label_pc_125b4 ]
  %stack_var_-44.8142 = phi i32 [ %stack_var_-44.17266.ph, %dec_label_pc_124b8 ], [ %v1_125b8, %dec_label_pc_125b4 ]
  %v2_12550 = add nsw i32 %storemerge57144, -1
  %v6_1255028 = lshr i32 %v4_12524, %storemerge57144
  %v1_12554 = urem i32 %v6_1255028, 2
  %v2_12568 = icmp eq i32 %v1_12554, 0
  %v3_12568 = icmp ne i1 %v2_12568, true
  store i1 %v3_12568, i1* %cpsr_c.global-to-local, align 1
  %v9_12568 = icmp ne i32 %v1_12554, 0
  store i1 %v9_12568, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12568, label %dec_label_pc_12570, label %dec_label_pc_125b4

dec_label_pc_12570:                               ; preds = %dec_label_pc_12548
  %v2_12574 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12574 = ptrtoint %_IO_FILE* %v2_12574 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12574, i32* %r0.global-to-local, align 4
  %v7_12584 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12574, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.8142)
  %v2_1258c = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_1258c = ptrtoint %_IO_FILE* %v2_1258c to i32
  store i32 %v3_1258c, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12598 = call i32 @fputc(i32 44, %_IO_FILE* %v2_1258c)
  store i32 %stack_var_-44.8142, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_125a4 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_125a4, i32* %r0.global-to-local, align 4
  %v1_125ac = add i32 %stack_var_-40.17143, 1
  br label %dec_label_pc_125b4

dec_label_pc_125b4:                               ; preds = %dec_label_pc_12548, %dec_label_pc_12570
  %stack_var_-40.16 = phi i32 [ %v1_125ac, %dec_label_pc_12570 ], [ %stack_var_-40.17143, %dec_label_pc_12548 ]
  %v1_125b8 = add i32 %stack_var_-44.8142, 1
  store i32 %v1_12554, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_125c8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_125c8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_125dc = icmp slt i32 %storemerge57144, 1
  %v7_125dc = icmp eq i32 %v2_12550, 0
  store i1 %v7_125dc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_125dc, label %dec_label_pc_125e4, label %dec_label_pc_12548

dec_label_pc_125e4:                               ; preds = %dec_label_pc_125b4
  %tmp2156 = add i32 %stack_var_-44.17266.ph, 8
  %v3_125e4 = load i8, i8* %stack_var_-598, align 1
  %v4_125e4 = zext i8 %v3_125e4 to i32
  store i32 %v4_125e4, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cbc.204 to i32), i32* %r0.global-to-local, align 4
  %v3_125f8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cbc.204 to i8*))
  store i32 %v3_125f8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12608

dec_label_pc_12608:                               ; preds = %dec_label_pc_125e4, %dec_label_pc_12674
  %storemerge58147 = phi i32 [ 7, %dec_label_pc_125e4 ], [ %v2_12610, %dec_label_pc_12674 ]
  %stack_var_-40.19146 = phi i32 [ %stack_var_-40.16, %dec_label_pc_125e4 ], [ %stack_var_-40.18, %dec_label_pc_12674 ]
  %stack_var_-44.9145 = phi i32 [ %tmp2156, %dec_label_pc_125e4 ], [ %v1_12678, %dec_label_pc_12674 ]
  %v2_12610 = add nsw i32 %storemerge58147, -1
  %v6_1261026 = lshr i32 %v4_125e4, %storemerge58147
  %v1_12614 = urem i32 %v6_1261026, 2
  %v2_12628 = icmp eq i32 %v1_12614, 0
  %v3_12628 = icmp ne i1 %v2_12628, true
  store i1 %v3_12628, i1* %cpsr_c.global-to-local, align 1
  %v9_12628 = icmp ne i32 %v1_12614, 0
  store i1 %v9_12628, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12628, label %dec_label_pc_12630, label %dec_label_pc_12674

dec_label_pc_12630:                               ; preds = %dec_label_pc_12608
  %v2_12634 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12634 = ptrtoint %_IO_FILE* %v2_12634 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12634, i32* %r0.global-to-local, align 4
  %v7_12644 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12634, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.9145)
  %v2_1264c = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_1264c = ptrtoint %_IO_FILE* %v2_1264c to i32
  store i32 %v3_1264c, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12658 = call i32 @fputc(i32 44, %_IO_FILE* %v2_1264c)
  store i32 %stack_var_-44.9145, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12664 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12664, i32* %r0.global-to-local, align 4
  %v1_1266c = add i32 %stack_var_-40.19146, 1
  br label %dec_label_pc_12674

dec_label_pc_12674:                               ; preds = %dec_label_pc_12608, %dec_label_pc_12630
  %stack_var_-40.18 = phi i32 [ %v1_1266c, %dec_label_pc_12630 ], [ %stack_var_-40.19146, %dec_label_pc_12608 ]
  %v1_12678 = add i32 %stack_var_-44.9145, 1
  store i32 %v1_12614, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12688 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12688, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_1269c = icmp slt i32 %storemerge58147, 1
  %v7_1269c = icmp eq i32 %v2_12610, 0
  store i1 %v7_1269c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_1269c, label %dec_label_pc_126a4, label %dec_label_pc_12608

dec_label_pc_126a4:                               ; preds = %dec_label_pc_12674
  %tmp2157 = add i32 %stack_var_-44.17266.ph, 16
  %v3_126a4 = load i8, i8* %stack_var_-599, align 1
  %v4_126a4 = zext i8 %v3_126a4 to i32
  store i32 %v4_126a4, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cdc.206 to i32), i32* %r0.global-to-local, align 4
  %v3_126b8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cdc.206 to i8*))
  store i32 %v3_126b8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_126c8

dec_label_pc_126c8:                               ; preds = %dec_label_pc_126a4, %dec_label_pc_1273c
  %storemerge59150 = phi i32 [ 7, %dec_label_pc_126a4 ], [ %v2_126d0, %dec_label_pc_1273c ]
  %stack_var_-40.21149 = phi i32 [ %stack_var_-40.18, %dec_label_pc_126a4 ], [ %stack_var_-40.20, %dec_label_pc_1273c ]
  %stack_var_-44.10148 = phi i32 [ %tmp2157, %dec_label_pc_126a4 ], [ %v1_12740, %dec_label_pc_1273c ]
  %v2_126d0 = add nsw i32 %storemerge59150, -1
  %v6_126d024 = lshr i32 %v4_126a4, %storemerge59150
  %v1_126d4 = urem i32 %v6_126d024, 2
  %v2_126f0 = icmp eq i32 %v1_126d4, 0
  %v3_126f0 = icmp ne i1 %v2_126f0, true
  store i1 %v3_126f0, i1* %cpsr_c.global-to-local, align 1
  %v9_126f0 = icmp ne i32 %v1_126d4, 0
  store i1 %v9_126f0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_126f0, label %dec_label_pc_126f8, label %dec_label_pc_1273c

dec_label_pc_126f8:                               ; preds = %dec_label_pc_126c8
  %v2_126fc = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_126fc = ptrtoint %_IO_FILE* %v2_126fc to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_126fc, i32* %r0.global-to-local, align 4
  %v7_1270c = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_126fc, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.10148)
  %v2_12714 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12714 = ptrtoint %_IO_FILE* %v2_12714 to i32
  store i32 %v3_12714, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12720 = call i32 @fputc(i32 44, %_IO_FILE* %v2_12714)
  store i32 %stack_var_-44.10148, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_1272c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_1272c, i32* %r0.global-to-local, align 4
  %v1_12734 = add i32 %stack_var_-40.21149, 1
  br label %dec_label_pc_1273c

dec_label_pc_1273c:                               ; preds = %dec_label_pc_126c8, %dec_label_pc_126f8
  %stack_var_-40.20 = phi i32 [ %v1_12734, %dec_label_pc_126f8 ], [ %stack_var_-40.21149, %dec_label_pc_126c8 ]
  %v1_12740 = add i32 %stack_var_-44.10148, 1
  store i32 %v1_126d4, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12750 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12750, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12764 = icmp slt i32 %storemerge59150, 1
  %v7_12764 = icmp eq i32 %v2_126d0, 0
  store i1 %v7_12764, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12764, label %dec_label_pc_1276c, label %dec_label_pc_126c8

dec_label_pc_1276c:                               ; preds = %dec_label_pc_1273c
  %tmp2158 = add i32 %stack_var_-44.17266.ph, 24
  %v3_1276c = load i8, i8* %stack_var_-600, align 1
  %v4_1276c = zext i8 %v3_1276c to i32
  store i32 %v4_1276c, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cfc.208 to i32), i32* %r0.global-to-local, align 4
  %v3_12780 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cfc.208 to i8*))
  store i32 %v3_12780, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12790

dec_label_pc_12790:                               ; preds = %dec_label_pc_1276c, %dec_label_pc_12808
  %storemerge60153 = phi i32 [ 7, %dec_label_pc_1276c ], [ %v2_12798, %dec_label_pc_12808 ]
  %stack_var_-40.23152 = phi i32 [ %stack_var_-40.20, %dec_label_pc_1276c ], [ %stack_var_-40.22, %dec_label_pc_12808 ]
  %stack_var_-44.11151 = phi i32 [ %tmp2158, %dec_label_pc_1276c ], [ %v1_1280c, %dec_label_pc_12808 ]
  %v2_12798 = add nsw i32 %storemerge60153, -1
  %v6_1279822 = lshr i32 %v4_1276c, %storemerge60153
  %v1_1279c = urem i32 %v6_1279822, 2
  %v2_127b0 = icmp eq i32 %v1_1279c, 0
  %v3_127b0 = icmp ne i1 %v2_127b0, true
  store i1 %v3_127b0, i1* %cpsr_c.global-to-local, align 1
  %v9_127b0 = icmp ne i32 %v1_1279c, 0
  store i1 %v9_127b0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_127b0, label %dec_label_pc_127b8, label %dec_label_pc_12808

dec_label_pc_127b8:                               ; preds = %dec_label_pc_12790
  %v2_127bc = icmp ult i32 %stack_var_-44.11151, 28
  %v3_127bc = icmp ne i1 %v2_127bc, true
  store i1 %v3_127bc, i1* %cpsr_c.global-to-local, align 1
  %v9_127bc = icmp eq i32 %stack_var_-44.11151, 28
  store i1 %v9_127bc, i1* %cpsr_z.global-to-local, align 1
  %v8_127c0 = icmp sgt i32 %stack_var_-44.11151, 28
  br i1 %v8_127c0, label %dec_label_pc_12808, label %dec_label_pc_127c4

dec_label_pc_127c4:                               ; preds = %dec_label_pc_127b8
  %v2_127c8 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_127c8 = ptrtoint %_IO_FILE* %v2_127c8 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_127c8, i32* %r0.global-to-local, align 4
  %v7_127d8 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_127c8, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.11151)
  %v2_127e0 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_127e0 = ptrtoint %_IO_FILE* %v2_127e0 to i32
  store i32 %v3_127e0, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_127ec = call i32 @fputc(i32 44, %_IO_FILE* %v2_127e0)
  store i32 %stack_var_-44.11151, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_127f8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_127f8, i32* %r0.global-to-local, align 4
  %v1_12800 = add i32 %stack_var_-40.23152, 1
  br label %dec_label_pc_12808

dec_label_pc_12808:                               ; preds = %dec_label_pc_12790, %dec_label_pc_127c4, %dec_label_pc_127b8
  %stack_var_-40.22 = phi i32 [ %stack_var_-40.23152, %dec_label_pc_127b8 ], [ %v1_12800, %dec_label_pc_127c4 ], [ %stack_var_-40.23152, %dec_label_pc_12790 ]
  %v1_1280c = add i32 %stack_var_-44.11151, 1
  store i32 %v1_1279c, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_1281c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_1281c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12830 = icmp slt i32 %storemerge60153, 1
  %v7_12830 = icmp eq i32 %v2_12798, 0
  store i1 %v7_12830, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12830, label %dec_label_pc_12d10.loopexit97, label %dec_label_pc_12790

dec_label_pc_1283c:                               ; preds = %dec_label_pc_11034
  store i32 ptrtoint (i8** @global_var_15d64.218 to i32), i32* %r0.global-to-local, align 4
  %v3_12840 = call i32 @puts(i8* bitcast (i8** @global_var_15d64.218 to i8*))
  %v2_12848 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([6 x i8]* @global_var_15d80.220 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12848, i32* %r0.global-to-local, align 4
  %v4_12858 = call i32 @write(i32 %v2_12848, i32* bitcast ([6 x i8]* @global_var_15d80.220 to i32*), i32 5)
  store i32 %v4_12858, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12920

dec_label_pc_12868:                               ; preds = %dec_label_pc_12920
  %v2_12870 = add i32 %v4_12948, %v4_12934
  %v4_12874 = inttoptr i32 %v2_12870 to i8*
  %v1_1287c = add i32 %v2_12870, -1
  %v1_12880 = inttoptr i32 %v1_1287c to i8*
  %v2_12880 = load i8, i8* %v1_12880, align 1
  %v2_12884 = icmp ult i8 %v2_12880, 62
  %v3_12884 = icmp ne i1 %v2_12884, true
  store i1 %v3_12884, i1* %cpsr_c.global-to-local, align 1
  %v9_12884 = icmp eq i8 %v2_12880, 62
  store i1 %v9_12884, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12884, label %dec_label_pc_128ec.preheader, label %dec_label_pc_12920

dec_label_pc_128ec.preheader:                     ; preds = %dec_label_pc_12868
  %v2_128f8110 = load i8, i8* %tmp2137, align 4
  %v2_128fc112 = icmp ult i8 %v2_128f8110, 16
  %v3_128fc113 = icmp ne i1 %v2_128fc112, true
  store i1 %v3_128fc113, i1* %cpsr_c.global-to-local, align 1
  %v9_128fc114 = icmp eq i8 %v2_128f8110, 16
  store i1 %v9_128fc114, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_128fc114, label %dec_label_pc_12904, label %dec_label_pc_128a0

dec_label_pc_128a0:                               ; preds = %dec_label_pc_128ec.preheader, %dec_label_pc_128e0.dec_label_pc_128a0_crit_edge
  %v2_128ac = phi i8 [ %v2_128ac.pre, %dec_label_pc_128e0.dec_label_pc_128a0_crit_edge ], [ %v2_128f8110, %dec_label_pc_128ec.preheader ]
  %v1_128f8118 = phi i8* [ %v1_128f8, %dec_label_pc_128e0.dec_label_pc_128a0_crit_edge ], [ %tmp2137, %dec_label_pc_128ec.preheader ]
  %stack_var_-192.1116 = phi i32 [ %stack_var_-192.0, %dec_label_pc_128e0.dec_label_pc_128a0_crit_edge ], [ 0, %dec_label_pc_128ec.preheader ]
  %storemerge115 = phi i32 [ %v1_128e4, %dec_label_pc_128e0.dec_label_pc_128a0_crit_edge ], [ 0, %dec_label_pc_128ec.preheader ]
  %v2_128b0 = icmp ult i8 %v2_128ac, 13
  %v3_128b0 = icmp ne i1 %v2_128b0, true
  store i1 %v3_128b0, i1* %cpsr_c.global-to-local, align 1
  %v9_128b0 = icmp eq i8 %v2_128ac, 13
  store i1 %v9_128b0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_128b0, label %dec_label_pc_128e0, label %dec_label_pc_128b8

dec_label_pc_128b8:                               ; preds = %dec_label_pc_128a0
  %v1_128bc = add i32 %stack_var_-192.1116, 1
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  %v2_128d0 = load i8, i8* %v1_128f8118, align 1
  store i32 %v13_10b10, i32* %r1.global-to-local, align 4
  %v3_128dc = add i32 %v2_128d8, %stack_var_-192.1116
  %v4_128dc = inttoptr i32 %v3_128dc to i8*
  store i8 %v2_128d0, i8* %v4_128dc, align 1
  br label %dec_label_pc_128e0

dec_label_pc_128e0:                               ; preds = %dec_label_pc_128b8, %dec_label_pc_128a0
  %stack_var_-192.0 = phi i32 [ %stack_var_-192.1116, %dec_label_pc_128a0 ], [ %v1_128bc, %dec_label_pc_128b8 ]
  %v1_128e4 = add i32 %storemerge115, 1
  %v2_128f4 = add i32 %v1_128e4, %v2_11034
  %v1_128f8 = inttoptr i32 %v2_128f4 to i8*
  %v2_128f8 = load i8, i8* %v1_128f8, align 1
  %v2_128fc = icmp ult i8 %v2_128f8, 16
  %v3_128fc = icmp ne i1 %v2_128fc, true
  store i1 %v3_128fc, i1* %cpsr_c.global-to-local, align 1
  %v9_128fc = icmp eq i8 %v2_128f8, 16
  store i1 %v9_128fc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_128fc, label %dec_label_pc_12904, label %dec_label_pc_128e0.dec_label_pc_128a0_crit_edge

dec_label_pc_128e0.dec_label_pc_128a0_crit_edge:  ; preds = %dec_label_pc_128e0
  %v2_128ac.pre = load i8, i8* %v1_128f8, align 1
  br label %dec_label_pc_128a0

dec_label_pc_12904:                               ; preds = %dec_label_pc_128e0, %dec_label_pc_128ec.preheader
  store i32 %v2_11034, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15b5c.160 to i32), i32* %r0.global-to-local, align 4
  %v3_12910 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15b5c.160 to i8*))
  store i32 %v3_12910, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_1295c

dec_label_pc_12920:                               ; preds = %dec_label_pc_12868, %dec_label_pc_1283c
  %stack_var_-28.16 = phi i8* [ %tmp2137, %dec_label_pc_1283c ], [ %v4_12874, %dec_label_pc_12868 ]
  %v2_12924 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_12924, i32* %r0.global-to-local, align 4
  %v4_12934 = ptrtoint i8* %stack_var_-28.16 to i32
  %v1_1293c = sub i32 %v2_12938, %v4_12934
  store i32 %v4_12934, i32* %r1.global-to-local, align 4
  %v2_12948 = bitcast i8* %stack_var_-28.16 to i32*
  %v4_12948 = call i32 @read(i32 %v2_12924, i32* %v2_12948, i32 %v1_1293c)
  store i32 %v4_12948, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_12954 = icmp eq i32 %v4_12948, 0
  store i1 %v7_12954, i1* %cpsr_z.global-to-local, align 1
  %v8_12958 = icmp sgt i32 %v4_12948, 0
  br i1 %v8_12958, label %dec_label_pc_12868, label %dec_label_pc_1295c

dec_label_pc_1295c:                               ; preds = %dec_label_pc_12920, %dec_label_pc_12904
  %stack_var_-28.17 = phi i8* [ %v4_12874, %dec_label_pc_12904 ], [ %stack_var_-28.16, %dec_label_pc_12920 ]
  %stack_var_-32.0 = phi i32 [ 1, %dec_label_pc_12904 ], [ 0, %dec_label_pc_12920 ]
  store i8 0, i8* %stack_var_-28.17, align 1
  store i32 ptrtoint ([3 x i8]* @global_var_15c3c.190 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11034, i32* %r0.global-to-local, align 4
  %v6_12974 = call i8* @strstr(i8* %tmp2137, i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_15c3c.190, i32 0, i32 0))
  %v8_12974 = ptrtoint i8* %v6_12974 to i32
  store i32 %v8_12974, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_1297c = icmp eq i8* %v6_12974, null
  store i1 %v7_1297c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_1297c, label %dec_label_pc_12d10.backedge, label %dec_label_pc_12984

dec_label_pc_12984:                               ; preds = %dec_label_pc_1295c
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_1299c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_129b8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_129d4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_129ec = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  %v3_129f0 = load i8, i8* %stack_var_-597, align 1
  %v4_129f0 = zext i8 %v3_129f0 to i32
  store i32 %v4_129f0, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c48.194 to i32), i32* %r0.global-to-local, align 4
  %v3_12a04 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c48.194 to i8*))
  store i32 %v3_12a04, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12a14

dec_label_pc_12a14:                               ; preds = %dec_label_pc_12984, %dec_label_pc_12a80
  %storemerge53121 = phi i32 [ 7, %dec_label_pc_12984 ], [ %v2_12a1c, %dec_label_pc_12a80 ]
  %stack_var_-44.12119 = phi i32 [ %stack_var_-44.17266, %dec_label_pc_12984 ], [ %v1_12a84, %dec_label_pc_12a80 ]
  %v2_12a1c = add nsw i32 %storemerge53121, -1
  %v6_12a1c20 = lshr i32 %v4_129f0, %storemerge53121
  %v1_12a20 = urem i32 %v6_12a1c20, 2
  %v2_12a34 = icmp eq i32 %v1_12a20, 0
  %v3_12a34 = icmp ne i1 %v2_12a34, true
  store i1 %v3_12a34, i1* %cpsr_c.global-to-local, align 1
  %v9_12a34 = icmp ne i32 %v1_12a20, 0
  store i1 %v9_12a34, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12a34, label %dec_label_pc_12a3c, label %dec_label_pc_12a80

dec_label_pc_12a3c:                               ; preds = %dec_label_pc_12a14
  %v2_12a40 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12a40 = ptrtoint %_IO_FILE* %v2_12a40 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12a40, i32* %r0.global-to-local, align 4
  %v7_12a50 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12a40, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.12119)
  %v2_12a58 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12a58 = ptrtoint %_IO_FILE* %v2_12a58 to i32
  store i32 %v3_12a58, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12a64 = call i32 @fputc(i32 44, %_IO_FILE* %v2_12a58)
  store i32 %stack_var_-44.12119, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12a70 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12a70, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12a80

dec_label_pc_12a80:                               ; preds = %dec_label_pc_12a14, %dec_label_pc_12a3c
  %v1_12a84 = add i32 %stack_var_-44.12119, 1
  store i32 %v1_12a20, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12a94 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12a94, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12aa8 = icmp slt i32 %storemerge53121, 1
  %v7_12aa8 = icmp eq i32 %v2_12a1c, 0
  store i1 %v7_12aa8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12aa8, label %dec_label_pc_12ab0, label %dec_label_pc_12a14

dec_label_pc_12ab0:                               ; preds = %dec_label_pc_12a80
  %tmp2160 = add i32 %stack_var_-44.17266, 8
  %v3_12ab0 = load i8, i8* %stack_var_-598, align 1
  %v4_12ab0 = zext i8 %v3_12ab0 to i32
  store i32 %v4_12ab0, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cbc.204 to i32), i32* %r0.global-to-local, align 4
  %v3_12ac4 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cbc.204 to i8*))
  store i32 %v3_12ac4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12ad4

dec_label_pc_12ad4:                               ; preds = %dec_label_pc_12ab0, %dec_label_pc_12b40
  %storemerge54124 = phi i32 [ 7, %dec_label_pc_12ab0 ], [ %v2_12adc, %dec_label_pc_12b40 ]
  %stack_var_-44.13122 = phi i32 [ %tmp2160, %dec_label_pc_12ab0 ], [ %v1_12b44, %dec_label_pc_12b40 ]
  %v2_12adc = add nsw i32 %storemerge54124, -1
  %v6_12adc18 = lshr i32 %v4_12ab0, %storemerge54124
  %v1_12ae0 = urem i32 %v6_12adc18, 2
  %v2_12af4 = icmp eq i32 %v1_12ae0, 0
  %v3_12af4 = icmp ne i1 %v2_12af4, true
  store i1 %v3_12af4, i1* %cpsr_c.global-to-local, align 1
  %v9_12af4 = icmp ne i32 %v1_12ae0, 0
  store i1 %v9_12af4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12af4, label %dec_label_pc_12afc, label %dec_label_pc_12b40

dec_label_pc_12afc:                               ; preds = %dec_label_pc_12ad4
  %v2_12b00 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12b00 = ptrtoint %_IO_FILE* %v2_12b00 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12b00, i32* %r0.global-to-local, align 4
  %v7_12b10 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12b00, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.13122)
  %v2_12b18 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12b18 = ptrtoint %_IO_FILE* %v2_12b18 to i32
  store i32 %v3_12b18, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12b24 = call i32 @fputc(i32 44, %_IO_FILE* %v2_12b18)
  store i32 %stack_var_-44.13122, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12b30 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12b30, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12b40

dec_label_pc_12b40:                               ; preds = %dec_label_pc_12ad4, %dec_label_pc_12afc
  %v1_12b44 = add i32 %stack_var_-44.13122, 1
  store i32 %v1_12ae0, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12b54 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12b54, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12b68 = icmp slt i32 %storemerge54124, 1
  %v7_12b68 = icmp eq i32 %v2_12adc, 0
  store i1 %v7_12b68, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12b68, label %dec_label_pc_12b70, label %dec_label_pc_12ad4

dec_label_pc_12b70:                               ; preds = %dec_label_pc_12b40
  %tmp2161 = add i32 %stack_var_-44.17266, 16
  %v3_12b70 = load i8, i8* %stack_var_-599, align 1
  %v4_12b70 = zext i8 %v3_12b70 to i32
  store i32 %v4_12b70, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cdc.206 to i32), i32* %r0.global-to-local, align 4
  %v3_12b84 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cdc.206 to i8*))
  store i32 %v3_12b84, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12b94

dec_label_pc_12b94:                               ; preds = %dec_label_pc_12b70, %dec_label_pc_12c08
  %storemerge55127 = phi i32 [ 7, %dec_label_pc_12b70 ], [ %v2_12b9c, %dec_label_pc_12c08 ]
  %stack_var_-44.14125 = phi i32 [ %tmp2161, %dec_label_pc_12b70 ], [ %v1_12c0c, %dec_label_pc_12c08 ]
  %v2_12b9c = add nsw i32 %storemerge55127, -1
  %v6_12b9c16 = lshr i32 %v4_12b70, %storemerge55127
  %v1_12ba0 = urem i32 %v6_12b9c16, 2
  %v2_12bbc = icmp eq i32 %v1_12ba0, 0
  %v3_12bbc = icmp ne i1 %v2_12bbc, true
  store i1 %v3_12bbc, i1* %cpsr_c.global-to-local, align 1
  %v9_12bbc = icmp ne i32 %v1_12ba0, 0
  store i1 %v9_12bbc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12bbc, label %dec_label_pc_12bc4, label %dec_label_pc_12c08

dec_label_pc_12bc4:                               ; preds = %dec_label_pc_12b94
  %v2_12bc8 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12bc8 = ptrtoint %_IO_FILE* %v2_12bc8 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12bc8, i32* %r0.global-to-local, align 4
  %v7_12bd8 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12bc8, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.14125)
  %v2_12be0 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12be0 = ptrtoint %_IO_FILE* %v2_12be0 to i32
  store i32 %v3_12be0, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12bec = call i32 @fputc(i32 44, %_IO_FILE* %v2_12be0)
  store i32 %stack_var_-44.14125, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12bf8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12bf8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12c08

dec_label_pc_12c08:                               ; preds = %dec_label_pc_12b94, %dec_label_pc_12bc4
  %v1_12c0c = add i32 %stack_var_-44.14125, 1
  store i32 %v1_12ba0, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12c1c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12c1c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12c30 = icmp slt i32 %storemerge55127, 1
  %v7_12c30 = icmp eq i32 %v2_12b9c, 0
  store i1 %v7_12c30, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12c30, label %dec_label_pc_12c38, label %dec_label_pc_12b94

dec_label_pc_12c38:                               ; preds = %dec_label_pc_12c08
  %tmp2162 = add i32 %stack_var_-44.17266, 24
  %v3_12c38 = load i8, i8* %stack_var_-600, align 1
  %v4_12c38 = zext i8 %v3_12c38 to i32
  store i32 %v4_12c38, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cfc.208 to i32), i32* %r0.global-to-local, align 4
  %v3_12c4c = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cfc.208 to i8*))
  store i32 %v3_12c4c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 false, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12c5c

dec_label_pc_12c5c:                               ; preds = %dec_label_pc_12c38, %dec_label_pc_12cc8
  %storemerge56130 = phi i32 [ 7, %dec_label_pc_12c38 ], [ %v2_12c64, %dec_label_pc_12cc8 ]
  %stack_var_-44.15128 = phi i32 [ %tmp2162, %dec_label_pc_12c38 ], [ %v1_12ccc, %dec_label_pc_12cc8 ]
  %v2_12c64 = add nsw i32 %storemerge56130, -1
  %v6_12c6414 = lshr i32 %v4_12c38, %storemerge56130
  %v1_12c68 = urem i32 %v6_12c6414, 2
  %v2_12c7c = icmp eq i32 %v1_12c68, 0
  %v3_12c7c = icmp ne i1 %v2_12c7c, true
  store i1 %v3_12c7c, i1* %cpsr_c.global-to-local, align 1
  %v9_12c7c = icmp ne i32 %v1_12c68, 0
  store i1 %v9_12c7c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12c7c, label %dec_label_pc_12c84, label %dec_label_pc_12cc8

dec_label_pc_12c84:                               ; preds = %dec_label_pc_12c5c
  %v2_12c88 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12c88 = ptrtoint %_IO_FILE* %v2_12c88 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15c68.196 to i32), i32* %r1.global-to-local, align 4
  store i32 %v3_12c88, i32* %r0.global-to-local, align 4
  %v7_12c98 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v2_12c88, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c68.196, i32 0, i32 0), i32 %stack_var_-44.15128)
  %v2_12ca0 = load %_IO_FILE*, %_IO_FILE** @global_var_270b8.152, align 4
  %v3_12ca0 = ptrtoint %_IO_FILE* %v2_12ca0 to i32
  store i32 %v3_12ca0, i32* %r1.global-to-local, align 4
  store i32 44, i32* %r0.global-to-local, align 4
  %v4_12cac = call i32 @fputc(i32 44, %_IO_FILE* %v2_12ca0)
  store i32 %stack_var_-44.15128, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15c70.198 to i32), i32* %r0.global-to-local, align 4
  %v3_12cb8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15c70.198 to i8*))
  store i32 %v3_12cb8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12cc8

dec_label_pc_12cc8:                               ; preds = %dec_label_pc_12c5c, %dec_label_pc_12c84
  %v1_12ccc = add i32 %stack_var_-44.15128, 1
  store i32 %v1_12c68, i32* %r1.global-to-local, align 4
  store i32 ptrtoint (i8** @global_var_15cb0.202 to i32), i32* %r0.global-to-local, align 4
  %v3_12cdc = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15cb0.202 to i8*))
  store i32 %v3_12cdc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v6_12cf0 = icmp slt i32 %storemerge56130, 1
  %v7_12cf0 = icmp eq i32 %v2_12c64, 0
  store i1 %v7_12cf0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v6_12cf0, label %dec_label_pc_12cf8.loopexit, label %dec_label_pc_12c5c

dec_label_pc_12cf8.loopexit:                      ; preds = %dec_label_pc_12cc8
  %tmp2163 = add i32 %stack_var_-44.17266, 32
  br label %dec_label_pc_12d10.backedge

dec_label_pc_12d10.loopexit95:                    ; preds = %dec_label_pc_11e74
  %tmp2164 = add i32 %stack_var_-44.17266.ph, 32
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_12d10.loopexit96:                    ; preds = %dec_label_pc_12338
  %tmp2165 = add i32 %stack_var_-44.17266.ph, 32
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_12d10.loopexit97:                    ; preds = %dec_label_pc_12808
  %tmp2166 = add i32 %stack_var_-44.17266.ph, 32
  br label %dec_label_pc_12d10.backedge.thread

dec_label_pc_15168.preheader:                     ; preds = %dec_label_pc_12d10.backedge
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v9_1516c = icmp eq i32 %stack_var_-32.0, 1
  store i1 %v9_1516c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1516c, label %dec_label_pc_12d20.lr.ph, label %dec_label_pc_15174

dec_label_pc_12d20.lr.ph:                         ; preds = %dec_label_pc_15168.preheader
  %v1_12d24 = add i32 %stack_var_-52.2, -1
  %v2_12da8 = ptrtoint i32* %stack_var_-596 to i32
  %v2_150ac = ptrtoint i32* %stack_var_-2120 to i32
  %tmp2167 = bitcast i32* %stack_var_-2120 to i8*
  %v2_13764 = ptrtoint i32* %stack_var_-2056 to i32
  %tmp2168 = bitcast i32* %stack_var_-2056 to i8*
  br label %dec_label_pc_12d20

dec_label_pc_12d20:                               ; preds = %dec_label_pc_15168.loopexit, %dec_label_pc_12d20.lr.ph
  %stack_var_-48.0107 = phi i32 [ %tmp1886, %dec_label_pc_12d20.lr.ph ], [ %., %dec_label_pc_15168.loopexit ]
  %stack_var_-36.0106 = phi i32 [ 0, %dec_label_pc_12d20.lr.ph ], [ %storemerge50, %dec_label_pc_15168.loopexit ]
  %v7_12d30 = icmp sgt i32 %v1_12d24, %stack_var_-36.0106
  %v1_12d38 = add i32 %stack_var_-36.0106, 1
  %storemerge50 = select i1 %v7_12d30, i32 %v1_12d38, i32 0
  %v2_12d50 = icmp eq i32 %stack_var_-48.0107, 0
  %v3_12d50 = icmp ne i1 %v2_12d50, true
  store i1 %v3_12d50, i1* %cpsr_c.global-to-local, align 1
  %v9_12d50 = icmp eq i32 %stack_var_-48.0107, 1
  store i1 %v9_12d50, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12d50, label %dec_label_pc_12d58, label %dec_label_pc_12d9c

dec_label_pc_12d58:                               ; preds = %dec_label_pc_12d20
  %v2_12d5c = load i32, i32* @global_var_270c8.227, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_12d60 = icmp eq i32 %v2_12d5c, 0
  store i1 %v7_12d60, i1* %cpsr_z.global-to-local, align 1
  br i1 %v7_12d60, label %dec_label_pc_12d68, label %dec_label_pc_12d84

dec_label_pc_12d68:                               ; preds = %dec_label_pc_12d58
  store i8 12, i8* bitcast (i8** @global_var_272cc.229 to i8*), align 4
  store i32 1, i32* @global_var_270c8.227, align 4
  br label %dec_label_pc_12d9c

dec_label_pc_12d84:                               ; preds = %dec_label_pc_12d58
  store i8 13, i8* bitcast (i8** @global_var_272cc.229 to i8*), align 4
  store i32 0, i32* @global_var_270c8.227, align 4
  br label %dec_label_pc_12d9c

dec_label_pc_12d9c:                               ; preds = %dec_label_pc_12d20, %dec_label_pc_12d84, %dec_label_pc_12d68
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 %v2_12d50, i1* %cpsr_z.global-to-local, align 1
  br i1 %v2_12d50, label %dec_label_pc_12da8, label %dec_label_pc_12d9c.dec_label_pc_12dc0_crit_edge

dec_label_pc_12d9c.dec_label_pc_12dc0_crit_edge:  ; preds = %dec_label_pc_12d9c
  %v2_12dec.pre = load i8, i8* bitcast (i8** @global_var_272cc.229 to i8*), align 4
  br label %dec_label_pc_12dc0

dec_label_pc_12da8:                               ; preds = %dec_label_pc_12d9c
  %v2_12db0 = add i32 %storemerge50, %v2_12da8
  %v1_12db4 = inttoptr i32 %v2_12db0 to i8*
  %v2_12db4 = load i8, i8* %v1_12db4, align 1
  store i8 %v2_12db4, i8* bitcast (i8** @global_var_272cc.229 to i8*), align 4
  br label %dec_label_pc_12dc0

dec_label_pc_12dc0:                               ; preds = %dec_label_pc_12d9c.dec_label_pc_12dc0_crit_edge, %dec_label_pc_12da8
  %v2_12dec = phi i8 [ %v2_12dec.pre, %dec_label_pc_12d9c.dec_label_pc_12dc0_crit_edge ], [ %v2_12db4, %dec_label_pc_12da8 ]
  %tmp2170 = zext i1 %v9_12d50 to i32
  %. = xor i32 %tmp2170, 1
  %v3_12dec = zext i8 %v2_12dec to i32
  %v1_12df0 = add nsw i32 %v3_12dec, -4
  %v9_12df4 = icmp eq i32 %v1_12df0, 88
  store i1 %v9_12df4, i1* %cpsr_z.global-to-local, align 1
  store i32 %v1_12df0, i32* @1, align 4
  %tmp2172 = and i32 %v1_12df0, 1073741824
  %v7_12df8 = icmp ne i32 %tmp2172, 0
  store i1 %v7_12df8, i1* %cpsr_c.global-to-local, align 1
  switch i8 %v2_12dec, label %dec_label_pc_15158.preheader [
    i8 4, label %dec_label_pc_12f64
    i8 5, label %dec_label_pc_13048
    i8 6, label %dec_label_pc_13120
    i8 7, label %dec_label_pc_1320c
    i8 8, label %dec_label_pc_132f8
    i8 9, label %dec_label_pc_133e4
    i8 10, label %dec_label_pc_13538
    i8 11, label %dec_label_pc_1361c
    i8 12, label %dec_label_pc_13778
    i8 13, label %dec_label_pc_1388c
    i8 14, label %dec_label_pc_139d4
    i8 15, label %dec_label_pc_13ab4
    i8 16, label %dec_label_pc_13b8c
    i8 17, label %dec_label_pc_13c9c
    i8 18, label %dec_label_pc_13d80
    i8 19, label %dec_label_pc_13e38
    i8 20, label %dec_label_pc_13ef0
    i8 21, label %dec_label_pc_13fcc
    i8 22, label %dec_label_pc_140a0
    i8 23, label %dec_label_pc_141c8
    i8 24, label %dec_label_pc_1429c
    i8 25, label %dec_label_pc_14370
    i8 26, label %dec_label_pc_14444
    i8 27, label %dec_label_pc_14518
    i8 28, label %dec_label_pc_145ec
    i8 29, label %dec_label_pc_146c0
    i8 92, label %dec_label_pc_14868
    i8 31, label %dec_label_pc_14794
    i8 70, label %dec_label_pc_14ea8
    i8 60, label %dec_label_pc_14f80
    i8 55, label %dec_label_pc_14d30
    i8 54, label %dec_label_pc_14be0
    i8 53, label %dec_label_pc_14a90
    i8 52, label %dec_label_pc_14940
  ]

dec_label_pc_12f64:                               ; preds = %dec_label_pc_12dc0
  %v2_12f68 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15d88.232 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12f68, i32* %r0.global-to-local, align 4
  %v4_12f78 = call i32 @write(i32 %v2_12f68, i32* bitcast ([7 x i8]* @global_var_15d88.232 to i32*), i32 6)
  store i32 %v4_12f78, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_12fac

dec_label_pc_12f88:                               ; preds = %dec_label_pc_12fac
  %v2_12f90 = add i32 %v4_12fd4, %v4_12fc0
  %v4_12f94 = inttoptr i32 %v2_12f90 to i8*
  %v1_12f9c = add i32 %v2_12f90, -1
  %v1_12fa0 = inttoptr i32 %v1_12f9c to i8*
  %v2_12fa0 = load i8, i8* %v1_12fa0, align 1
  %v2_12fa4 = icmp ult i8 %v2_12fa0, 62
  %v3_12fa4 = icmp ne i1 %v2_12fa4, true
  store i1 %v3_12fa4, i1* %cpsr_c.global-to-local, align 1
  %v9_12fa4 = icmp eq i8 %v2_12fa0, 62
  store i1 %v9_12fa4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_12fa4, label %dec_label_pc_12ff0, label %dec_label_pc_12fac

dec_label_pc_12fac:                               ; preds = %dec_label_pc_12f88, %dec_label_pc_12f64
  %stack_var_-28.18 = phi i8* [ %tmp2137, %dec_label_pc_12f64 ], [ %v4_12f94, %dec_label_pc_12f88 ]
  %v2_12fb0 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_12fb0, i32* %r0.global-to-local, align 4
  %v4_12fc0 = ptrtoint i8* %stack_var_-28.18 to i32
  %v1_12fc8 = sub i32 %v2_12938, %v4_12fc0
  store i32 %v4_12fc0, i32* %r1.global-to-local, align 4
  %v2_12fd4 = bitcast i8* %stack_var_-28.18 to i32*
  %v4_12fd4 = call i32 @read(i32 %v2_12fb0, i32* %v2_12fd4, i32 %v1_12fc8)
  store i32 %v4_12fd4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_12fe0 = icmp eq i32 %v4_12fd4, 0
  store i1 %v7_12fe0, i1* %cpsr_z.global-to-local, align 1
  %v8_12fe4 = icmp sgt i32 %v4_12fd4, 0
  br i1 %v8_12fe4, label %dec_label_pc_12f88, label %dec_label_pc_12ff0

dec_label_pc_12ff0:                               ; preds = %dec_label_pc_12f88, %dec_label_pc_12fac
  %stack_var_-28.19 = phi i8* [ %v4_12f94, %dec_label_pc_12f88 ], [ %stack_var_-28.18, %dec_label_pc_12fac ]
  store i8 0, i8* %stack_var_-28.19, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13014 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_13014, i32* %r0.global-to-local, align 4
  %v3_13018 = load i8, i8* %stack_var_-597, align 1
  %v4_13018 = zext i8 %v3_13018 to i32
  %v1_1301c = call float @__asm_vmov(i32 %v4_13018)
  %v1_13020 = call double @__asm_vcvt.f64.s32(float %v1_1301c)
  %v1_13024 = call double @__asm_vldr(i32 1717986918)
  %v2_13028 = call double @__asm_vdiv.f64(double %v1_13020, double %v1_13024)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_13038 = call i32 @__asm_vmov.2(double %v2_13028)
  %v2_13038 = sext i32 %v1_13038 to i64
  %v3_13038 = bitcast i64 %v2_13038 to double
  store i32 ptrtoint ([6 x i8]* @global_var_15d90.236 to i32), i32* %r1.global-to-local, align 4
  %v11_13040 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([6 x i8], [6 x i8]* @global_var_15d90.236, i32 0, i32 0), double %v3_13038)
  store i32 %v11_13040, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13048:                               ; preds = %dec_label_pc_12dc0
  %v2_1304c = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15d98.238 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1304c, i32* %r0.global-to-local, align 4
  %v4_1305c = call i32 @write(i32 %v2_1304c, i32* bitcast ([7 x i8]* @global_var_15d98.238 to i32*), i32 6)
  store i32 %v4_1305c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13090

dec_label_pc_1306c:                               ; preds = %dec_label_pc_13090
  %v2_13074 = add i32 %v4_130b8, %v4_130a4
  %v4_13078 = inttoptr i32 %v2_13074 to i8*
  %v1_13080 = add i32 %v2_13074, -1
  %v1_13084 = inttoptr i32 %v1_13080 to i8*
  %v2_13084 = load i8, i8* %v1_13084, align 1
  %v2_13088 = icmp ult i8 %v2_13084, 62
  %v3_13088 = icmp ne i1 %v2_13088, true
  store i1 %v3_13088, i1* %cpsr_c.global-to-local, align 1
  %v9_13088 = icmp eq i8 %v2_13084, 62
  store i1 %v9_13088, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13088, label %dec_label_pc_130d4, label %dec_label_pc_13090

dec_label_pc_13090:                               ; preds = %dec_label_pc_1306c, %dec_label_pc_13048
  %stack_var_-28.20 = phi i8* [ %tmp2137, %dec_label_pc_13048 ], [ %v4_13078, %dec_label_pc_1306c ]
  %v2_13094 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13094, i32* %r0.global-to-local, align 4
  %v4_130a4 = ptrtoint i8* %stack_var_-28.20 to i32
  %v1_130ac = sub i32 %v2_12938, %v4_130a4
  store i32 %v4_130a4, i32* %r1.global-to-local, align 4
  %v2_130b8 = bitcast i8* %stack_var_-28.20 to i32*
  %v4_130b8 = call i32 @read(i32 %v2_13094, i32* %v2_130b8, i32 %v1_130ac)
  store i32 %v4_130b8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_130c4 = icmp eq i32 %v4_130b8, 0
  store i1 %v7_130c4, i1* %cpsr_z.global-to-local, align 1
  %v8_130c8 = icmp sgt i32 %v4_130b8, 0
  br i1 %v8_130c8, label %dec_label_pc_1306c, label %dec_label_pc_130d4

dec_label_pc_130d4:                               ; preds = %dec_label_pc_1306c, %dec_label_pc_13090
  %stack_var_-28.21 = phi i8* [ %v4_13078, %dec_label_pc_1306c ], [ %stack_var_-28.20, %dec_label_pc_13090 ]
  store i8 0, i8* %stack_var_-28.21, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_130f8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_130fc = load i8, i8* %stack_var_-597, align 1
  %v4_130fc = zext i8 %v3_130fc to i32
  %v1_13100 = add nsw i32 %v4_130fc, -40
  store i32 ptrtoint ([7 x i8]* @global_var_15da0.240 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_13118 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15da0.240, i32 0, i32 0), i32 %v1_13100)
  store i32 %v7_13118, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13120:                               ; preds = %dec_label_pc_12dc0
  %v2_13124 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15da8.242 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13124, i32* %r0.global-to-local, align 4
  %v4_13134 = call i32 @write(i32 %v2_13124, i32* bitcast ([7 x i8]* @global_var_15da8.242 to i32*), i32 6)
  store i32 %v4_13134, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13168

dec_label_pc_13144:                               ; preds = %dec_label_pc_13168
  %v2_1314c = add i32 %v4_13190, %v4_1317c
  %v4_13150 = inttoptr i32 %v2_1314c to i8*
  %v1_13158 = add i32 %v2_1314c, -1
  %v1_1315c = inttoptr i32 %v1_13158 to i8*
  %v2_1315c = load i8, i8* %v1_1315c, align 1
  %v2_13160 = icmp ult i8 %v2_1315c, 62
  %v3_13160 = icmp ne i1 %v2_13160, true
  store i1 %v3_13160, i1* %cpsr_c.global-to-local, align 1
  %v9_13160 = icmp eq i8 %v2_1315c, 62
  store i1 %v9_13160, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13160, label %dec_label_pc_131ac, label %dec_label_pc_13168

dec_label_pc_13168:                               ; preds = %dec_label_pc_13144, %dec_label_pc_13120
  %stack_var_-28.22 = phi i8* [ %tmp2137, %dec_label_pc_13120 ], [ %v4_13150, %dec_label_pc_13144 ]
  %v2_1316c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_1316c, i32* %r0.global-to-local, align 4
  %v4_1317c = ptrtoint i8* %stack_var_-28.22 to i32
  %v1_13184 = sub i32 %v2_12938, %v4_1317c
  store i32 %v4_1317c, i32* %r1.global-to-local, align 4
  %v2_13190 = bitcast i8* %stack_var_-28.22 to i32*
  %v4_13190 = call i32 @read(i32 %v2_1316c, i32* %v2_13190, i32 %v1_13184)
  store i32 %v4_13190, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_1319c = icmp eq i32 %v4_13190, 0
  store i1 %v7_1319c, i1* %cpsr_z.global-to-local, align 1
  %v8_131a0 = icmp sgt i32 %v4_13190, 0
  br i1 %v8_131a0, label %dec_label_pc_13144, label %dec_label_pc_131ac

dec_label_pc_131ac:                               ; preds = %dec_label_pc_13144, %dec_label_pc_13168
  %stack_var_-28.23 = phi i8* [ %v4_13150, %dec_label_pc_13144 ], [ %stack_var_-28.22, %dec_label_pc_13168 ]
  store i8 0, i8* %stack_var_-28.23, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_131d0 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_131d0, i32* %r0.global-to-local, align 4
  %v3_131d4 = load i8, i8* %stack_var_-597, align 1
  %v4_131d4 = zext i8 %v3_131d4 to i32
  %v1_131d8 = call float @__asm_vmov(i32 %v4_131d4)
  %v1_131dc = call double @__asm_vcvt.f64.s32(float %v1_131d8)
  %v1_131e0 = call double @__asm_vldr(i32 1202590843)
  %v2_131e4 = call double @__asm_vdiv.f64(double %v1_131dc, double %v1_131e0)
  %v1_131e8 = call double @__asm_vldr(i32 0)
  %v2_131ec = call double @__asm_vsub.f64(double %v2_131e4, double %v1_131e8)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_131fc = call i32 @__asm_vmov.2(double %v2_131ec)
  %v2_131fc = sext i32 %v1_131fc to i64
  %v3_131fc = bitcast i64 %v2_131fc to double
  store i32 ptrtoint ([7 x i8]* @global_var_15db0.246 to i32), i32* %r1.global-to-local, align 4
  %v11_13204 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15db0.246, i32 0, i32 0), double %v3_131fc)
  store i32 %v11_13204, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_1320c:                               ; preds = %dec_label_pc_12dc0
  %v2_13210 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15db8.248 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13210, i32* %r0.global-to-local, align 4
  %v4_13220 = call i32 @write(i32 %v2_13210, i32* bitcast ([7 x i8]* @global_var_15db8.248 to i32*), i32 6)
  store i32 %v4_13220, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13254

dec_label_pc_13230:                               ; preds = %dec_label_pc_13254
  %v2_13238 = add i32 %v4_1327c, %v4_13268
  %v4_1323c = inttoptr i32 %v2_13238 to i8*
  %v1_13244 = add i32 %v2_13238, -1
  %v1_13248 = inttoptr i32 %v1_13244 to i8*
  %v2_13248 = load i8, i8* %v1_13248, align 1
  %v2_1324c = icmp ult i8 %v2_13248, 62
  %v3_1324c = icmp ne i1 %v2_1324c, true
  store i1 %v3_1324c, i1* %cpsr_c.global-to-local, align 1
  %v9_1324c = icmp eq i8 %v2_13248, 62
  store i1 %v9_1324c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1324c, label %dec_label_pc_13298, label %dec_label_pc_13254

dec_label_pc_13254:                               ; preds = %dec_label_pc_13230, %dec_label_pc_1320c
  %stack_var_-28.24 = phi i8* [ %tmp2137, %dec_label_pc_1320c ], [ %v4_1323c, %dec_label_pc_13230 ]
  %v2_13258 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13258, i32* %r0.global-to-local, align 4
  %v4_13268 = ptrtoint i8* %stack_var_-28.24 to i32
  %v1_13270 = sub i32 %v2_12938, %v4_13268
  store i32 %v4_13268, i32* %r1.global-to-local, align 4
  %v2_1327c = bitcast i8* %stack_var_-28.24 to i32*
  %v4_1327c = call i32 @read(i32 %v2_13258, i32* %v2_1327c, i32 %v1_13270)
  store i32 %v4_1327c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13288 = icmp eq i32 %v4_1327c, 0
  store i1 %v7_13288, i1* %cpsr_z.global-to-local, align 1
  %v8_1328c = icmp sgt i32 %v4_1327c, 0
  br i1 %v8_1328c, label %dec_label_pc_13230, label %dec_label_pc_13298

dec_label_pc_13298:                               ; preds = %dec_label_pc_13230, %dec_label_pc_13254
  %stack_var_-28.25 = phi i8* [ %v4_1323c, %dec_label_pc_13230 ], [ %stack_var_-28.24, %dec_label_pc_13254 ]
  store i8 0, i8* %stack_var_-28.25, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_132bc = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_132bc, i32* %r0.global-to-local, align 4
  %v3_132c0 = load i8, i8* %stack_var_-597, align 1
  %v4_132c0 = zext i8 %v3_132c0 to i32
  %v1_132c4 = call float @__asm_vmov(i32 %v4_132c0)
  %v1_132c8 = call double @__asm_vcvt.f64.s32(float %v1_132c4)
  %v1_132cc = call double @__asm_vldr(i32 1202590843)
  %v2_132d0 = call double @__asm_vdiv.f64(double %v1_132c8, double %v1_132cc)
  %v1_132d4 = call double @__asm_vldr(i32 0)
  %v2_132d8 = call double @__asm_vsub.f64(double %v2_132d0, double %v1_132d4)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_132e8 = call i32 @__asm_vmov.2(double %v2_132d8)
  %v2_132e8 = sext i32 %v1_132e8 to i64
  %v3_132e8 = bitcast i64 %v2_132e8 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15dc0.250 to i32), i32* %r1.global-to-local, align 4
  %v11_132f0 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15dc0.250, i32 0, i32 0), double %v3_132e8)
  store i32 %v11_132f0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_132f8:                               ; preds = %dec_label_pc_12dc0
  %v2_132fc = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15dc8.252 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_132fc, i32* %r0.global-to-local, align 4
  %v4_1330c = call i32 @write(i32 %v2_132fc, i32* bitcast ([7 x i8]* @global_var_15dc8.252 to i32*), i32 6)
  store i32 %v4_1330c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13340

dec_label_pc_1331c:                               ; preds = %dec_label_pc_13340
  %v2_13324 = add i32 %v4_13368, %v4_13354
  %v4_13328 = inttoptr i32 %v2_13324 to i8*
  %v1_13330 = add i32 %v2_13324, -1
  %v1_13334 = inttoptr i32 %v1_13330 to i8*
  %v2_13334 = load i8, i8* %v1_13334, align 1
  %v2_13338 = icmp ult i8 %v2_13334, 62
  %v3_13338 = icmp ne i1 %v2_13338, true
  store i1 %v3_13338, i1* %cpsr_c.global-to-local, align 1
  %v9_13338 = icmp eq i8 %v2_13334, 62
  store i1 %v9_13338, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13338, label %dec_label_pc_13384, label %dec_label_pc_13340

dec_label_pc_13340:                               ; preds = %dec_label_pc_1331c, %dec_label_pc_132f8
  %stack_var_-28.26 = phi i8* [ %tmp2137, %dec_label_pc_132f8 ], [ %v4_13328, %dec_label_pc_1331c ]
  %v2_13344 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13344, i32* %r0.global-to-local, align 4
  %v4_13354 = ptrtoint i8* %stack_var_-28.26 to i32
  %v1_1335c = sub i32 %v2_12938, %v4_13354
  store i32 %v4_13354, i32* %r1.global-to-local, align 4
  %v2_13368 = bitcast i8* %stack_var_-28.26 to i32*
  %v4_13368 = call i32 @read(i32 %v2_13344, i32* %v2_13368, i32 %v1_1335c)
  store i32 %v4_13368, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13374 = icmp eq i32 %v4_13368, 0
  store i1 %v7_13374, i1* %cpsr_z.global-to-local, align 1
  %v8_13378 = icmp sgt i32 %v4_13368, 0
  br i1 %v8_13378, label %dec_label_pc_1331c, label %dec_label_pc_13384

dec_label_pc_13384:                               ; preds = %dec_label_pc_1331c, %dec_label_pc_13340
  %stack_var_-28.27 = phi i8* [ %v4_13328, %dec_label_pc_1331c ], [ %stack_var_-28.26, %dec_label_pc_13340 ]
  store i8 0, i8* %stack_var_-28.27, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_133a8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_133a8, i32* %r0.global-to-local, align 4
  %v3_133ac = load i8, i8* %stack_var_-597, align 1
  %v4_133ac = zext i8 %v3_133ac to i32
  %v1_133b0 = call float @__asm_vmov(i32 %v4_133ac)
  %v1_133b4 = call double @__asm_vcvt.f64.s32(float %v1_133b0)
  %v1_133b8 = call double @__asm_vldr(i32 1202590843)
  %v2_133bc = call double @__asm_vdiv.f64(double %v1_133b4, double %v1_133b8)
  %v1_133c0 = call double @__asm_vldr(i32 0)
  %v2_133c4 = call double @__asm_vsub.f64(double %v2_133bc, double %v1_133c0)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_133d4 = call i32 @__asm_vmov.2(double %v2_133c4)
  %v2_133d4 = sext i32 %v1_133d4 to i64
  %v3_133d4 = bitcast i64 %v2_133d4 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15dd0.254 to i32), i32* %r1.global-to-local, align 4
  %v11_133dc = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15dd0.254, i32 0, i32 0), double %v3_133d4)
  store i32 %v11_133dc, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_133e4:                               ; preds = %dec_label_pc_12dc0
  %v2_133e8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15dd8.256 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_133e8, i32* %r0.global-to-local, align 4
  %v4_133f8 = call i32 @write(i32 %v2_133e8, i32* bitcast ([7 x i8]* @global_var_15dd8.256 to i32*), i32 6)
  store i32 %v4_133f8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13494

dec_label_pc_13470:                               ; preds = %dec_label_pc_13494
  %v2_13478 = add i32 %v4_134bc, %v4_134a8
  %v4_1347c = inttoptr i32 %v2_13478 to i8*
  %v1_13484 = add i32 %v2_13478, -1
  %v1_13488 = inttoptr i32 %v1_13484 to i8*
  %v2_13488 = load i8, i8* %v1_13488, align 1
  %v2_1348c = icmp ult i8 %v2_13488, 62
  %v3_1348c = icmp ne i1 %v2_1348c, true
  store i1 %v3_1348c, i1* %cpsr_c.global-to-local, align 1
  %v9_1348c = icmp eq i8 %v2_13488, 62
  store i1 %v9_1348c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1348c, label %dec_label_pc_134d8, label %dec_label_pc_13494

dec_label_pc_13494:                               ; preds = %dec_label_pc_13470, %dec_label_pc_133e4
  %stack_var_-28.28 = phi i8* [ %tmp2137, %dec_label_pc_133e4 ], [ %v4_1347c, %dec_label_pc_13470 ]
  %v2_13498 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13498, i32* %r0.global-to-local, align 4
  %v4_134a8 = ptrtoint i8* %stack_var_-28.28 to i32
  %v1_134b0 = sub i32 %v2_12938, %v4_134a8
  store i32 %v4_134a8, i32* %r1.global-to-local, align 4
  %v2_134bc = bitcast i8* %stack_var_-28.28 to i32*
  %v4_134bc = call i32 @read(i32 %v2_13498, i32* %v2_134bc, i32 %v1_134b0)
  store i32 %v4_134bc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_134c8 = icmp eq i32 %v4_134bc, 0
  store i1 %v7_134c8, i1* %cpsr_z.global-to-local, align 1
  %v8_134cc = icmp sgt i32 %v4_134bc, 0
  br i1 %v8_134cc, label %dec_label_pc_13470, label %dec_label_pc_134d8

dec_label_pc_134d8:                               ; preds = %dec_label_pc_13470, %dec_label_pc_13494
  %stack_var_-28.29 = phi i8* [ %v4_1347c, %dec_label_pc_13470 ], [ %stack_var_-28.28, %dec_label_pc_13494 ]
  store i8 0, i8* %stack_var_-28.29, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_134fc = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_134fc, i32* %r0.global-to-local, align 4
  %v3_13500 = load i8, i8* %stack_var_-597, align 1
  %v4_13500 = zext i8 %v3_13500 to i32
  %v1_13504 = call float @__asm_vmov(i32 %v4_13500)
  %v1_13508 = call double @__asm_vcvt.f64.s32(float %v1_13504)
  %v1_1350c = call double @__asm_vldr(i32 1202590843)
  %v2_13510 = call double @__asm_vdiv.f64(double %v1_13508, double %v1_1350c)
  %v1_13514 = call double @__asm_vldr(i32 0)
  %v2_13518 = call double @__asm_vsub.f64(double %v2_13510, double %v1_13514)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_13528 = call i32 @__asm_vmov.2(double %v2_13518)
  %v2_13528 = sext i32 %v1_13528 to i64
  %v3_13528 = bitcast i64 %v2_13528 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15de0.260 to i32), i32* %r1.global-to-local, align 4
  %v11_13530 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15de0.260, i32 0, i32 0), double %v3_13528)
  store i32 %v11_13530, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13538:                               ; preds = %dec_label_pc_12dc0
  %v2_1353c = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15de8.263 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1353c, i32* %r0.global-to-local, align 4
  %v4_1354c = call i32 @write(i32 %v2_1353c, i32* bitcast ([7 x i8]* @global_var_15de8.263 to i32*), i32 6)
  store i32 %v4_1354c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13580

dec_label_pc_1355c:                               ; preds = %dec_label_pc_13580
  %v2_13564 = add i32 %v4_135a8, %v4_13594
  %v4_13568 = inttoptr i32 %v2_13564 to i8*
  %v1_13570 = add i32 %v2_13564, -1
  %v1_13574 = inttoptr i32 %v1_13570 to i8*
  %v2_13574 = load i8, i8* %v1_13574, align 1
  %v2_13578 = icmp ult i8 %v2_13574, 62
  %v3_13578 = icmp ne i1 %v2_13578, true
  store i1 %v3_13578, i1* %cpsr_c.global-to-local, align 1
  %v9_13578 = icmp eq i8 %v2_13574, 62
  store i1 %v9_13578, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13578, label %dec_label_pc_135c4, label %dec_label_pc_13580

dec_label_pc_13580:                               ; preds = %dec_label_pc_1355c, %dec_label_pc_13538
  %stack_var_-28.30 = phi i8* [ %tmp2137, %dec_label_pc_13538 ], [ %v4_13568, %dec_label_pc_1355c ]
  %v2_13584 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13584, i32* %r0.global-to-local, align 4
  %v4_13594 = ptrtoint i8* %stack_var_-28.30 to i32
  %v1_1359c = sub i32 %v2_12938, %v4_13594
  store i32 %v4_13594, i32* %r1.global-to-local, align 4
  %v2_135a8 = bitcast i8* %stack_var_-28.30 to i32*
  %v4_135a8 = call i32 @read(i32 %v2_13584, i32* %v2_135a8, i32 %v1_1359c)
  store i32 %v4_135a8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_135b4 = icmp eq i32 %v4_135a8, 0
  store i1 %v7_135b4, i1* %cpsr_z.global-to-local, align 1
  %v8_135b8 = icmp sgt i32 %v4_135a8, 0
  br i1 %v8_135b8, label %dec_label_pc_1355c, label %dec_label_pc_135c4

dec_label_pc_135c4:                               ; preds = %dec_label_pc_1355c, %dec_label_pc_13580
  %stack_var_-28.31 = phi i8* [ %v4_13568, %dec_label_pc_1355c ], [ %stack_var_-28.30, %dec_label_pc_13580 ]
  store i8 0, i8* %stack_var_-28.31, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_135e8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_135ec = load i8, i8* %stack_var_-597, align 1
  %v4_135ec = zext i8 %v3_135ec to i32
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  %v2_135fc = mul nuw nsw i32 %v4_135ec, 3
  store i32 ptrtoint ([7 x i8]* @global_var_15df0.266 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_13614 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15df0.266, i32 0, i32 0), i32 %v2_135fc)
  store i32 %v7_13614, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_1361c:                               ; preds = %dec_label_pc_12dc0
  %v2_13628 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15df8.268 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13628, i32* %r0.global-to-local, align 4
  %v4_13638 = call i32 @write(i32 %v2_13628, i32* bitcast ([7 x i8]* @global_var_15df8.268 to i32*), i32 6)
  store i32 %v4_13638, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_1366c

dec_label_pc_13648:                               ; preds = %dec_label_pc_1366c
  %v2_13650 = add i32 %v4_13694, %v4_13680
  %v4_13654 = inttoptr i32 %v2_13650 to i8*
  %v1_1365c = add i32 %v2_13650, -1
  %v1_13660 = inttoptr i32 %v1_1365c to i8*
  %v2_13660 = load i8, i8* %v1_13660, align 1
  %v2_13664 = icmp ult i8 %v2_13660, 62
  %v3_13664 = icmp ne i1 %v2_13664, true
  store i1 %v3_13664, i1* %cpsr_c.global-to-local, align 1
  %v9_13664 = icmp eq i8 %v2_13660, 62
  store i1 %v9_13664, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13664, label %dec_label_pc_136b0, label %dec_label_pc_1366c

dec_label_pc_1366c:                               ; preds = %dec_label_pc_13648, %dec_label_pc_1361c
  %stack_var_-28.32 = phi i8* [ %tmp2137, %dec_label_pc_1361c ], [ %v4_13654, %dec_label_pc_13648 ]
  %v2_13670 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13670, i32* %r0.global-to-local, align 4
  %v4_13680 = ptrtoint i8* %stack_var_-28.32 to i32
  %v1_13688 = sub i32 %v2_12938, %v4_13680
  store i32 %v4_13680, i32* %r1.global-to-local, align 4
  %v2_13694 = bitcast i8* %stack_var_-28.32 to i32*
  %v4_13694 = call i32 @read(i32 %v2_13670, i32* %v2_13694, i32 %v1_13688)
  store i32 %v4_13694, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_136a0 = icmp eq i32 %v4_13694, 0
  store i1 %v7_136a0, i1* %cpsr_z.global-to-local, align 1
  %v8_136a4 = icmp sgt i32 %v4_13694, 0
  br i1 %v8_136a4, label %dec_label_pc_13648, label %dec_label_pc_136b0

dec_label_pc_136b0:                               ; preds = %dec_label_pc_13648, %dec_label_pc_1366c
  %stack_var_-28.33 = phi i8* [ %v4_13654, %dec_label_pc_13648 ], [ %stack_var_-28.32, %dec_label_pc_1366c ]
  store i8 0, i8* %stack_var_-28.33, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_136d4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_136d4, i32* %r0.global-to-local, align 4
  %v3_136d8 = load i8, i8* %stack_var_-597, align 1
  %v4_136d8 = zext i8 %v3_136d8 to i32
  %v1_136dc = add nsw i32 %v4_136d8, -101
  %v1_136e0 = call float @__asm_vmov(i32 %v1_136dc)
  %v1_136e4 = call float @__asm_vcvt.f32.s32(float %v1_136e0)
  call void @__asm_vstr(float %v1_136e4, i32 %tmp1881)
  %v4_136ec = call float @__asm_vldr.3(i32 %tmp1881)
  call void @__asm_vcmpe.f32(float %v4_136ec, i32 0)
  %v0_136f4 = load i32, i32* %apsr_nzcv.global-to-local, align 4
  %v1_136f4 = load i32, i32* %fpscr.global-to-local, align 4
  call void @__asm_vmrs(i32 %v0_136f4, i32 %v1_136f4)
  %v0_136f8 = load i1, i1* %cpsr_c.global-to-local, align 1
  %v1_136f8 = load i1, i1* %cpsr_z.global-to-local, align 1
  %v2_136f8 = icmp ne i1 %v1_136f8, true
  %v3_136f8 = icmp eq i1 %v0_136f8, %v2_136f8
  %v4_13718 = call float @__asm_vldr.3(i32 %tmp1881)
  %v1_1371c = call double @__asm_vcvt.f64.s32(float %v4_13718)
  br i1 %v3_136f8, label %dec_label_pc_13718, label %dec_label_pc_136fc

dec_label_pc_136fc:                               ; preds = %dec_label_pc_136b0
  %v1_13704 = call double @__asm_vldr(i32 -2021727006)
  %v2_13708 = call double @__asm_vmul.f64(double %v1_1371c, double %v1_13704)
  %v1_1370c = call float @__asm_vcvt.f32.f64(double %v2_13708)
  call void @__asm_vstr(float %v1_1370c, i32 %tmp1880)
  br label %dec_label_pc_13730

dec_label_pc_13718:                               ; preds = %dec_label_pc_136b0
  %v1_13720 = call double @__asm_vldr(i32 68554550)
  %v2_13724 = call double @__asm_vmul.f64(double %v1_1371c, double %v1_13720)
  %v1_13728 = call float @__asm_vcvt.f32.f64(double %v2_13724)
  call void @__asm_vstr(float %v1_13728, i32 %tmp1880)
  br label %dec_label_pc_13730

dec_label_pc_13730:                               ; preds = %dec_label_pc_13718, %dec_label_pc_136fc
  %v3_13730 = load i8, i8* %stack_var_-597, align 1
  %v4_13730 = zext i8 %v3_13730 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15e00.272 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_1374c = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e00.272, i32 0, i32 0), i32 %v4_13730)
  store i32 %v7_1374c, i32* %r0.global-to-local, align 4
  %v4_13750 = call float @__asm_vldr.3(i32 %tmp1880)
  %v1_13754 = call double @__asm_vcvt.f64.s32(float %v4_13750)
  store i32 %v2_13764, i32* %r0.global-to-local, align 4
  %v1_13768 = call i32 @__asm_vmov.2(double %v1_13754)
  %v2_13768 = sext i32 %v1_13768 to i64
  %v3_13768 = bitcast i64 %v2_13768 to double
  store i32 ptrtoint ([6 x i8]* @global_var_15e08.274 to i32), i32* %r1.global-to-local, align 4
  %v11_13770 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2168, i8* getelementptr inbounds ([6 x i8], [6 x i8]* @global_var_15e08.274, i32 0, i32 0), double %v3_13768)
  store i32 %v11_13770, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13778:                               ; preds = %dec_label_pc_12dc0
  %v2_1377c = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e10.276 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1377c, i32* %r0.global-to-local, align 4
  %v4_1378c = call i32 @write(i32 %v2_1377c, i32* bitcast ([7 x i8]* @global_var_15e10.276 to i32*), i32 6)
  store i32 %v4_1378c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_137c0

dec_label_pc_1379c:                               ; preds = %dec_label_pc_137c0
  %v2_137a4 = add i32 %v4_137e8, %v4_137d4
  %v4_137a8 = inttoptr i32 %v2_137a4 to i8*
  %v1_137b0 = add i32 %v2_137a4, -1
  %v1_137b4 = inttoptr i32 %v1_137b0 to i8*
  %v2_137b4 = load i8, i8* %v1_137b4, align 1
  %v2_137b8 = icmp ult i8 %v2_137b4, 62
  %v3_137b8 = icmp ne i1 %v2_137b8, true
  store i1 %v3_137b8, i1* %cpsr_c.global-to-local, align 1
  %v9_137b8 = icmp eq i8 %v2_137b4, 62
  store i1 %v9_137b8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_137b8, label %dec_label_pc_13804, label %dec_label_pc_137c0

dec_label_pc_137c0:                               ; preds = %dec_label_pc_1379c, %dec_label_pc_13778
  %stack_var_-28.34 = phi i8* [ %tmp2137, %dec_label_pc_13778 ], [ %v4_137a8, %dec_label_pc_1379c ]
  %v2_137c4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_137c4, i32* %r0.global-to-local, align 4
  %v4_137d4 = ptrtoint i8* %stack_var_-28.34 to i32
  %v1_137dc = sub i32 %v2_12938, %v4_137d4
  store i32 %v4_137d4, i32* %r1.global-to-local, align 4
  %v2_137e8 = bitcast i8* %stack_var_-28.34 to i32*
  %v4_137e8 = call i32 @read(i32 %v2_137c4, i32* %v2_137e8, i32 %v1_137dc)
  store i32 %v4_137e8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_137f4 = icmp eq i32 %v4_137e8, 0
  store i1 %v7_137f4, i1* %cpsr_z.global-to-local, align 1
  %v8_137f8 = icmp sgt i32 %v4_137e8, 0
  br i1 %v8_137f8, label %dec_label_pc_1379c, label %dec_label_pc_13804

dec_label_pc_13804:                               ; preds = %dec_label_pc_1379c, %dec_label_pc_137c0
  %stack_var_-28.35 = phi i8* [ %v4_137a8, %dec_label_pc_1379c ], [ %stack_var_-28.34, %dec_label_pc_137c0 ]
  store i8 0, i8* %stack_var_-28.35, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_13828 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13844 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_13848 = load i8, i8* %stack_var_-597, align 1
  %v4_13848 = zext i8 %v3_13848 to i32
  %v4_1384c = mul nuw nsw i32 %v4_13848, 256
  %v3_13850 = load i8, i8* %stack_var_-598, align 1
  %v4_13850 = zext i8 %v3_13850 to i32
  %v2_13854 = or i32 %v4_13850, %v4_1384c
  %v7_1385c = icmp eq i32 %v2_13854, 0
  store i1 %v7_1385c, i1* %cpsr_z.global-to-local, align 1
  %v1_13868 = and i32 %v4_13850, 2
  %v2_13868 = icmp ne i32 %v1_13868, 0
  store i1 %v2_13868, i1* %cpsr_c.global-to-local, align 1
  %v3_13868293 = udiv i32 %v2_13854, 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e18.278 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_13884 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e18.278, i32 0, i32 0), i32 %v3_13868293)
  store i32 %v7_13884, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_1388c:                               ; preds = %dec_label_pc_12dc0
  %v2_13890 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e20.280 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13890, i32* %r0.global-to-local, align 4
  %v4_138a0 = call i32 @write(i32 %v2_13890, i32* bitcast ([7 x i8]* @global_var_15e20.280 to i32*), i32 6)
  store i32 %v4_138a0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13944

dec_label_pc_13920:                               ; preds = %dec_label_pc_13944
  %v2_13928 = add i32 %v4_1396c, %v4_13958
  %v4_1392c = inttoptr i32 %v2_13928 to i8*
  %v1_13934 = add i32 %v2_13928, -1
  %v1_13938 = inttoptr i32 %v1_13934 to i8*
  %v2_13938 = load i8, i8* %v1_13938, align 1
  %v2_1393c = icmp ult i8 %v2_13938, 62
  %v3_1393c = icmp ne i1 %v2_1393c, true
  store i1 %v3_1393c, i1* %cpsr_c.global-to-local, align 1
  %v9_1393c = icmp eq i8 %v2_13938, 62
  store i1 %v9_1393c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1393c, label %dec_label_pc_13988, label %dec_label_pc_13944

dec_label_pc_13944:                               ; preds = %dec_label_pc_13920, %dec_label_pc_1388c
  %stack_var_-28.36 = phi i8* [ %tmp2137, %dec_label_pc_1388c ], [ %v4_1392c, %dec_label_pc_13920 ]
  %v2_13948 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13948, i32* %r0.global-to-local, align 4
  %v4_13958 = ptrtoint i8* %stack_var_-28.36 to i32
  %v1_13960 = sub i32 %v2_12938, %v4_13958
  store i32 %v4_13958, i32* %r1.global-to-local, align 4
  %v2_1396c = bitcast i8* %stack_var_-28.36 to i32*
  %v4_1396c = call i32 @read(i32 %v2_13948, i32* %v2_1396c, i32 %v1_13960)
  store i32 %v4_1396c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13978 = icmp eq i32 %v4_1396c, 0
  store i1 %v7_13978, i1* %cpsr_z.global-to-local, align 1
  %v8_1397c = icmp sgt i32 %v4_1396c, 0
  br i1 %v8_1397c, label %dec_label_pc_13920, label %dec_label_pc_13988

dec_label_pc_13988:                               ; preds = %dec_label_pc_13920, %dec_label_pc_13944
  %stack_var_-28.37 = phi i8* [ %v4_1392c, %dec_label_pc_13920 ], [ %stack_var_-28.36, %dec_label_pc_13944 ]
  store i8 0, i8* %stack_var_-28.37, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_139ac = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_139b0 = load i8, i8* %stack_var_-597, align 1
  %v4_139b0 = zext i8 %v3_139b0 to i32
  store i32 ptrtoint ([7 x i8]* @global_var_15e28.282 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_139cc = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e28.282, i32 0, i32 0), i32 %v4_139b0)
  store i32 %v7_139cc, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_139d4:                               ; preds = %dec_label_pc_12dc0
  %v2_139d8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e30.284 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_139d8, i32* %r0.global-to-local, align 4
  %v4_139e8 = call i32 @write(i32 %v2_139d8, i32* bitcast ([7 x i8]* @global_var_15e30.284 to i32*), i32 6)
  store i32 %v4_139e8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13a1c

dec_label_pc_139f8:                               ; preds = %dec_label_pc_13a1c
  %v2_13a00 = add i32 %v4_13a44, %v4_13a30
  %v4_13a04 = inttoptr i32 %v2_13a00 to i8*
  %v1_13a0c = add i32 %v2_13a00, -1
  %v1_13a10 = inttoptr i32 %v1_13a0c to i8*
  %v2_13a10 = load i8, i8* %v1_13a10, align 1
  %v2_13a14 = icmp ult i8 %v2_13a10, 62
  %v3_13a14 = icmp ne i1 %v2_13a14, true
  store i1 %v3_13a14, i1* %cpsr_c.global-to-local, align 1
  %v9_13a14 = icmp eq i8 %v2_13a10, 62
  store i1 %v9_13a14, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13a14, label %dec_label_pc_13a60, label %dec_label_pc_13a1c

dec_label_pc_13a1c:                               ; preds = %dec_label_pc_139f8, %dec_label_pc_139d4
  %stack_var_-28.38 = phi i8* [ %tmp2137, %dec_label_pc_139d4 ], [ %v4_13a04, %dec_label_pc_139f8 ]
  %v2_13a20 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13a20, i32* %r0.global-to-local, align 4
  %v4_13a30 = ptrtoint i8* %stack_var_-28.38 to i32
  %v1_13a38 = sub i32 %v2_12938, %v4_13a30
  store i32 %v4_13a30, i32* %r1.global-to-local, align 4
  %v2_13a44 = bitcast i8* %stack_var_-28.38 to i32*
  %v4_13a44 = call i32 @read(i32 %v2_13a20, i32* %v2_13a44, i32 %v1_13a38)
  store i32 %v4_13a44, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13a50 = icmp eq i32 %v4_13a44, 0
  store i1 %v7_13a50, i1* %cpsr_z.global-to-local, align 1
  %v8_13a54 = icmp sgt i32 %v4_13a44, 0
  br i1 %v8_13a54, label %dec_label_pc_139f8, label %dec_label_pc_13a60

dec_label_pc_13a60:                               ; preds = %dec_label_pc_139f8, %dec_label_pc_13a1c
  %stack_var_-28.39 = phi i8* [ %v4_13a04, %dec_label_pc_139f8 ], [ %stack_var_-28.38, %dec_label_pc_13a1c ]
  store i8 0, i8* %stack_var_-28.39, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13a84 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_13a88 = load i8, i8* %stack_var_-597, align 1
  %tmp2248 = urem i8 %v3_13a88, 2
  %v2_13a8c = icmp ne i8 %tmp2248, 0
  store i1 %v2_13a8c, i1* %cpsr_c.global-to-local, align 1
  %div = udiv i8 %v3_13a88, 2
  %v3_13a8c = zext i8 %div to i32
  %v1_13a94 = add nsw i32 %v3_13a8c, -64
  %v2_13a94 = sext i32 %v1_13a94 to i64
  %v3_13a94 = bitcast i64 %v2_13a94 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15e38.286 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v11_13aac = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e38.286, i32 0, i32 0), double %v3_13a94)
  store i32 %v11_13aac, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13ab4:                               ; preds = %dec_label_pc_12dc0
  %v2_13ab8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e40.288 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13ab8, i32* %r0.global-to-local, align 4
  %v4_13ac8 = call i32 @write(i32 %v2_13ab8, i32* bitcast ([7 x i8]* @global_var_15e40.288 to i32*), i32 6)
  store i32 %v4_13ac8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13afc

dec_label_pc_13ad8:                               ; preds = %dec_label_pc_13afc
  %v2_13ae0 = add i32 %v4_13b24, %v4_13b10
  %v4_13ae4 = inttoptr i32 %v2_13ae0 to i8*
  %v1_13aec = add i32 %v2_13ae0, -1
  %v1_13af0 = inttoptr i32 %v1_13aec to i8*
  %v2_13af0 = load i8, i8* %v1_13af0, align 1
  %v2_13af4 = icmp ult i8 %v2_13af0, 62
  %v3_13af4 = icmp ne i1 %v2_13af4, true
  store i1 %v3_13af4, i1* %cpsr_c.global-to-local, align 1
  %v9_13af4 = icmp eq i8 %v2_13af0, 62
  store i1 %v9_13af4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13af4, label %dec_label_pc_13b40, label %dec_label_pc_13afc

dec_label_pc_13afc:                               ; preds = %dec_label_pc_13ad8, %dec_label_pc_13ab4
  %stack_var_-28.40 = phi i8* [ %tmp2137, %dec_label_pc_13ab4 ], [ %v4_13ae4, %dec_label_pc_13ad8 ]
  %v2_13b00 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13b00, i32* %r0.global-to-local, align 4
  %v4_13b10 = ptrtoint i8* %stack_var_-28.40 to i32
  %v1_13b18 = sub i32 %v2_12938, %v4_13b10
  store i32 %v4_13b10, i32* %r1.global-to-local, align 4
  %v2_13b24 = bitcast i8* %stack_var_-28.40 to i32*
  %v4_13b24 = call i32 @read(i32 %v2_13b00, i32* %v2_13b24, i32 %v1_13b18)
  store i32 %v4_13b24, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13b30 = icmp eq i32 %v4_13b24, 0
  store i1 %v7_13b30, i1* %cpsr_z.global-to-local, align 1
  %v8_13b34 = icmp sgt i32 %v4_13b24, 0
  br i1 %v8_13b34, label %dec_label_pc_13ad8, label %dec_label_pc_13b40

dec_label_pc_13b40:                               ; preds = %dec_label_pc_13ad8, %dec_label_pc_13afc
  %stack_var_-28.41 = phi i8* [ %v4_13ae4, %dec_label_pc_13ad8 ], [ %stack_var_-28.40, %dec_label_pc_13afc ]
  store i8 0, i8* %stack_var_-28.41, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13b64 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_13b68 = load i8, i8* %stack_var_-597, align 1
  %v4_13b68 = zext i8 %v3_13b68 to i32
  %v1_13b6c = add nsw i32 %v4_13b68, -40
  store i32 ptrtoint ([7 x i8]* @global_var_15e48.290 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_13b84 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e48.290, i32 0, i32 0), i32 %v1_13b6c)
  store i32 %v7_13b84, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13b8c:                               ; preds = %dec_label_pc_12dc0
  %v2_13b90 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e50.292 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13b90, i32* %r0.global-to-local, align 4
  %v4_13ba0 = call i32 @write(i32 %v2_13b90, i32* bitcast ([7 x i8]* @global_var_15e50.292 to i32*), i32 6)
  store i32 %v4_13ba0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13bd4

dec_label_pc_13bb0:                               ; preds = %dec_label_pc_13bd4
  %v2_13bb8 = add i32 %v4_13bfc, %v4_13be8
  %v4_13bbc = inttoptr i32 %v2_13bb8 to i8*
  %v1_13bc4 = add i32 %v2_13bb8, -1
  %v1_13bc8 = inttoptr i32 %v1_13bc4 to i8*
  %v2_13bc8 = load i8, i8* %v1_13bc8, align 1
  %v2_13bcc = icmp ult i8 %v2_13bc8, 62
  %v3_13bcc = icmp ne i1 %v2_13bcc, true
  store i1 %v3_13bcc, i1* %cpsr_c.global-to-local, align 1
  %v9_13bcc = icmp eq i8 %v2_13bc8, 62
  store i1 %v9_13bcc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13bcc, label %dec_label_pc_13c18, label %dec_label_pc_13bd4

dec_label_pc_13bd4:                               ; preds = %dec_label_pc_13bb0, %dec_label_pc_13b8c
  %stack_var_-28.42 = phi i8* [ %tmp2137, %dec_label_pc_13b8c ], [ %v4_13bbc, %dec_label_pc_13bb0 ]
  %v2_13bd8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13bd8, i32* %r0.global-to-local, align 4
  %v4_13be8 = ptrtoint i8* %stack_var_-28.42 to i32
  %v1_13bf0 = sub i32 %v2_12938, %v4_13be8
  store i32 %v4_13be8, i32* %r1.global-to-local, align 4
  %v2_13bfc = bitcast i8* %stack_var_-28.42 to i32*
  %v4_13bfc = call i32 @read(i32 %v2_13bd8, i32* %v2_13bfc, i32 %v1_13bf0)
  store i32 %v4_13bfc, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13c08 = icmp eq i32 %v4_13bfc, 0
  store i1 %v7_13c08, i1* %cpsr_z.global-to-local, align 1
  %v8_13c0c = icmp sgt i32 %v4_13bfc, 0
  br i1 %v8_13c0c, label %dec_label_pc_13bb0, label %dec_label_pc_13c18

dec_label_pc_13c18:                               ; preds = %dec_label_pc_13bb0, %dec_label_pc_13bd4
  %stack_var_-28.43 = phi i8* [ %v4_13bbc, %dec_label_pc_13bb0 ], [ %stack_var_-28.42, %dec_label_pc_13bd4 ]
  store i8 0, i8* %stack_var_-28.43, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_13c3c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13c58 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_13c5c = load i8, i8* %stack_var_-597, align 1
  %v4_13c5c = zext i8 %v3_13c5c to i32
  %v4_13c60 = mul nuw nsw i32 %v4_13c5c, 256
  %v3_13c64 = load i8, i8* %stack_var_-598, align 1
  %v4_13c64 = zext i8 %v3_13c64 to i32
  %v2_13c68 = or i32 %v4_13c64, %v4_13c60
  %v3_13c749 = udiv i32 %v2_13c68, 100
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15e58.295 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_13c94 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e58.295, i32 0, i32 0), i32 %v3_13c749)
  store i32 %v7_13c94, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13c9c:                               ; preds = %dec_label_pc_12dc0
  %v2_13ca0 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e60.297 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13ca0, i32* %r0.global-to-local, align 4
  %v4_13cb0 = call i32 @write(i32 %v2_13ca0, i32* bitcast ([7 x i8]* @global_var_15e60.297 to i32*), i32 6)
  store i32 %v4_13cb0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13ce4

dec_label_pc_13cc0:                               ; preds = %dec_label_pc_13ce4
  %v2_13cc8 = add i32 %v4_13d0c, %v4_13cf8
  %v4_13ccc = inttoptr i32 %v2_13cc8 to i8*
  %v1_13cd4 = add i32 %v2_13cc8, -1
  %v1_13cd8 = inttoptr i32 %v1_13cd4 to i8*
  %v2_13cd8 = load i8, i8* %v1_13cd8, align 1
  %v2_13cdc = icmp ult i8 %v2_13cd8, 62
  %v3_13cdc = icmp ne i1 %v2_13cdc, true
  store i1 %v3_13cdc, i1* %cpsr_c.global-to-local, align 1
  %v9_13cdc = icmp eq i8 %v2_13cd8, 62
  store i1 %v9_13cdc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13cdc, label %dec_label_pc_13d28, label %dec_label_pc_13ce4

dec_label_pc_13ce4:                               ; preds = %dec_label_pc_13cc0, %dec_label_pc_13c9c
  %stack_var_-28.44 = phi i8* [ %tmp2137, %dec_label_pc_13c9c ], [ %v4_13ccc, %dec_label_pc_13cc0 ]
  %v2_13ce8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13ce8, i32* %r0.global-to-local, align 4
  %v4_13cf8 = ptrtoint i8* %stack_var_-28.44 to i32
  %v1_13d00 = sub i32 %v2_12938, %v4_13cf8
  store i32 %v4_13cf8, i32* %r1.global-to-local, align 4
  %v2_13d0c = bitcast i8* %stack_var_-28.44 to i32*
  %v4_13d0c = call i32 @read(i32 %v2_13ce8, i32* %v2_13d0c, i32 %v1_13d00)
  store i32 %v4_13d0c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13d18 = icmp eq i32 %v4_13d0c, 0
  store i1 %v7_13d18, i1* %cpsr_z.global-to-local, align 1
  %v8_13d1c = icmp sgt i32 %v4_13d0c, 0
  br i1 %v8_13d1c, label %dec_label_pc_13cc0, label %dec_label_pc_13d28

dec_label_pc_13d28:                               ; preds = %dec_label_pc_13cc0, %dec_label_pc_13ce4
  %stack_var_-28.45 = phi i8* [ %v4_13ccc, %dec_label_pc_13cc0 ], [ %stack_var_-28.44, %dec_label_pc_13ce4 ]
  store i8 0, i8* %stack_var_-28.45, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13d4c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_13d4c, i32* %r0.global-to-local, align 4
  %v3_13d50 = load i8, i8* %stack_var_-597, align 1
  %v4_13d50 = zext i8 %v3_13d50 to i32
  %v1_13d54 = call float @__asm_vmov(i32 %v4_13d50)
  %v1_13d58 = call double @__asm_vcvt.f64.s32(float %v1_13d54)
  %v1_13d5c = call double @__asm_vldr(i32 0)
  %v2_13d60 = call double @__asm_vmul.f64(double %v1_13d58, double %v1_13d5c)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_13d70 = call i32 @__asm_vmov.2(double %v2_13d60)
  %v2_13d70 = sext i32 %v1_13d70 to i64
  %v3_13d70 = bitcast i64 %v2_13d70 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15e68.300 to i32), i32* %r1.global-to-local, align 4
  %v11_13d78 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15e68.300, i32 0, i32 0), double %v3_13d70)
  store i32 %v11_13d78, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13d80:                               ; preds = %dec_label_pc_12dc0
  %v2_13d84 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e70.303 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13d84, i32* %r0.global-to-local, align 4
  %v4_13d94 = call i32 @write(i32 %v2_13d84, i32* bitcast ([7 x i8]* @global_var_15e70.303 to i32*), i32 6)
  store i32 %v4_13d94, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13dc8

dec_label_pc_13da4:                               ; preds = %dec_label_pc_13dc8
  %v2_13dac = add i32 %v4_13df0, %v4_13ddc
  %v4_13db0 = inttoptr i32 %v2_13dac to i8*
  %v1_13db8 = add i32 %v2_13dac, -1
  %v1_13dbc = inttoptr i32 %v1_13db8 to i8*
  %v2_13dbc = load i8, i8* %v1_13dbc, align 1
  %v2_13dc0 = icmp ult i8 %v2_13dbc, 62
  %v3_13dc0 = icmp ne i1 %v2_13dc0, true
  store i1 %v3_13dc0, i1* %cpsr_c.global-to-local, align 1
  %v9_13dc0 = icmp eq i8 %v2_13dbc, 62
  store i1 %v9_13dc0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13dc0, label %dec_label_pc_13e0c, label %dec_label_pc_13dc8

dec_label_pc_13dc8:                               ; preds = %dec_label_pc_13da4, %dec_label_pc_13d80
  %stack_var_-28.46 = phi i8* [ %tmp2137, %dec_label_pc_13d80 ], [ %v4_13db0, %dec_label_pc_13da4 ]
  %v2_13dcc = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13dcc, i32* %r0.global-to-local, align 4
  %v4_13ddc = ptrtoint i8* %stack_var_-28.46 to i32
  %v1_13de4 = sub i32 %v2_12938, %v4_13ddc
  store i32 %v4_13ddc, i32* %r1.global-to-local, align 4
  %v2_13df0 = bitcast i8* %stack_var_-28.46 to i32*
  %v4_13df0 = call i32 @read(i32 %v2_13dcc, i32* %v2_13df0, i32 %v1_13de4)
  store i32 %v4_13df0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13dfc = icmp eq i32 %v4_13df0, 0
  store i1 %v7_13dfc, i1* %cpsr_z.global-to-local, align 1
  %v8_13e00 = icmp sgt i32 %v4_13df0, 0
  br i1 %v8_13e00, label %dec_label_pc_13da4, label %dec_label_pc_13e0c

dec_label_pc_13e0c:                               ; preds = %dec_label_pc_13da4, %dec_label_pc_13dc8
  %stack_var_-28.47 = phi i8* [ %v4_13db0, %dec_label_pc_13da4 ], [ %stack_var_-28.46, %dec_label_pc_13dc8 ]
  store i8 0, i8* %stack_var_-28.47, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13e30 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_13e30, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13e38:                               ; preds = %dec_label_pc_12dc0
  %v2_13e3c = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e78.306 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13e3c, i32* %r0.global-to-local, align 4
  %v4_13e4c = call i32 @write(i32 %v2_13e3c, i32* bitcast ([7 x i8]* @global_var_15e78.306 to i32*), i32 6)
  store i32 %v4_13e4c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13e80

dec_label_pc_13e5c:                               ; preds = %dec_label_pc_13e80
  %v2_13e64 = add i32 %v4_13ea8, %v4_13e94
  %v4_13e68 = inttoptr i32 %v2_13e64 to i8*
  %v1_13e70 = add i32 %v2_13e64, -1
  %v1_13e74 = inttoptr i32 %v1_13e70 to i8*
  %v2_13e74 = load i8, i8* %v1_13e74, align 1
  %v2_13e78 = icmp ult i8 %v2_13e74, 62
  %v3_13e78 = icmp ne i1 %v2_13e78, true
  store i1 %v3_13e78, i1* %cpsr_c.global-to-local, align 1
  %v9_13e78 = icmp eq i8 %v2_13e74, 62
  store i1 %v9_13e78, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13e78, label %dec_label_pc_13ec4, label %dec_label_pc_13e80

dec_label_pc_13e80:                               ; preds = %dec_label_pc_13e5c, %dec_label_pc_13e38
  %stack_var_-28.48 = phi i8* [ %tmp2137, %dec_label_pc_13e38 ], [ %v4_13e68, %dec_label_pc_13e5c ]
  %v2_13e84 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13e84, i32* %r0.global-to-local, align 4
  %v4_13e94 = ptrtoint i8* %stack_var_-28.48 to i32
  %v1_13e9c = sub i32 %v2_12938, %v4_13e94
  store i32 %v4_13e94, i32* %r1.global-to-local, align 4
  %v2_13ea8 = bitcast i8* %stack_var_-28.48 to i32*
  %v4_13ea8 = call i32 @read(i32 %v2_13e84, i32* %v2_13ea8, i32 %v1_13e9c)
  store i32 %v4_13ea8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13eb4 = icmp eq i32 %v4_13ea8, 0
  store i1 %v7_13eb4, i1* %cpsr_z.global-to-local, align 1
  %v8_13eb8 = icmp sgt i32 %v4_13ea8, 0
  br i1 %v8_13eb8, label %dec_label_pc_13e5c, label %dec_label_pc_13ec4

dec_label_pc_13ec4:                               ; preds = %dec_label_pc_13e5c, %dec_label_pc_13e80
  %stack_var_-28.49 = phi i8* [ %v4_13e68, %dec_label_pc_13e5c ], [ %stack_var_-28.48, %dec_label_pc_13e80 ]
  store i8 0, i8* %stack_var_-28.49, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13ee8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_13ee8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13ef0:                               ; preds = %dec_label_pc_12dc0
  %v2_13ef4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e80.308 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13ef4, i32* %r0.global-to-local, align 4
  %v4_13f04 = call i32 @write(i32 %v2_13ef4, i32* bitcast ([7 x i8]* @global_var_15e80.308 to i32*), i32 6)
  store i32 %v4_13f04, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_13f40

dec_label_pc_13f1c:                               ; preds = %dec_label_pc_13f40
  %v2_13f24 = add i32 %v4_13f68, %v4_13f54
  %v4_13f28 = inttoptr i32 %v2_13f24 to i8*
  %v1_13f30 = add i32 %v2_13f24, -1
  %v1_13f34 = inttoptr i32 %v1_13f30 to i8*
  %v2_13f34 = load i8, i8* %v1_13f34, align 1
  %v2_13f38 = icmp ult i8 %v2_13f34, 62
  %v3_13f38 = icmp ne i1 %v2_13f38, true
  store i1 %v3_13f38, i1* %cpsr_c.global-to-local, align 1
  %v9_13f38 = icmp eq i8 %v2_13f34, 62
  store i1 %v9_13f38, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_13f38, label %dec_label_pc_13f84, label %dec_label_pc_13f40

dec_label_pc_13f40:                               ; preds = %dec_label_pc_13f1c, %dec_label_pc_13ef0
  %stack_var_-28.50 = phi i8* [ %tmp2137, %dec_label_pc_13ef0 ], [ %v4_13f28, %dec_label_pc_13f1c ]
  %v2_13f44 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_13f44, i32* %r0.global-to-local, align 4
  %v4_13f54 = ptrtoint i8* %stack_var_-28.50 to i32
  %v1_13f5c = sub i32 %v2_12938, %v4_13f54
  store i32 %v4_13f54, i32* %r1.global-to-local, align 4
  %v2_13f68 = bitcast i8* %stack_var_-28.50 to i32*
  %v4_13f68 = call i32 @read(i32 %v2_13f44, i32* %v2_13f68, i32 %v1_13f5c)
  store i32 %v4_13f68, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_13f74 = icmp eq i32 %v4_13f68, 0
  store i1 %v7_13f74, i1* %cpsr_z.global-to-local, align 1
  %v8_13f78 = icmp sgt i32 %v4_13f68, 0
  br i1 %v8_13f78, label %dec_label_pc_13f1c, label %dec_label_pc_13f84

dec_label_pc_13f84:                               ; preds = %dec_label_pc_13f1c, %dec_label_pc_13f40
  %stack_var_-28.51 = phi i8* [ %v4_13f28, %dec_label_pc_13f1c ], [ %stack_var_-28.50, %dec_label_pc_13f40 ]
  store i8 0, i8* %stack_var_-28.51, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_13fa8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_13fc4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_13fc4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_13fcc:                               ; preds = %dec_label_pc_12dc0
  %v2_13fd0 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e88.310 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_13fd0, i32* %r0.global-to-local, align 4
  %v4_13fe0 = call i32 @write(i32 %v2_13fd0, i32* bitcast ([7 x i8]* @global_var_15e88.310 to i32*), i32 6)
  store i32 %v4_13fe0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14014

dec_label_pc_13ff0:                               ; preds = %dec_label_pc_14014
  %v2_13ff8 = add i32 %v4_1403c, %v4_14028
  %v4_13ffc = inttoptr i32 %v2_13ff8 to i8*
  %v1_14004 = add i32 %v2_13ff8, -1
  %v1_14008 = inttoptr i32 %v1_14004 to i8*
  %v2_14008 = load i8, i8* %v1_14008, align 1
  %v2_1400c = icmp ult i8 %v2_14008, 62
  %v3_1400c = icmp ne i1 %v2_1400c, true
  store i1 %v3_1400c, i1* %cpsr_c.global-to-local, align 1
  %v9_1400c = icmp eq i8 %v2_14008, 62
  store i1 %v9_1400c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1400c, label %dec_label_pc_14058, label %dec_label_pc_14014

dec_label_pc_14014:                               ; preds = %dec_label_pc_13ff0, %dec_label_pc_13fcc
  %stack_var_-28.52 = phi i8* [ %tmp2137, %dec_label_pc_13fcc ], [ %v4_13ffc, %dec_label_pc_13ff0 ]
  %v2_14018 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14018, i32* %r0.global-to-local, align 4
  %v4_14028 = ptrtoint i8* %stack_var_-28.52 to i32
  %v1_14030 = sub i32 %v2_12938, %v4_14028
  store i32 %v4_14028, i32* %r1.global-to-local, align 4
  %v2_1403c = bitcast i8* %stack_var_-28.52 to i32*
  %v4_1403c = call i32 @read(i32 %v2_14018, i32* %v2_1403c, i32 %v1_14030)
  store i32 %v4_1403c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14048 = icmp eq i32 %v4_1403c, 0
  store i1 %v7_14048, i1* %cpsr_z.global-to-local, align 1
  %v8_1404c = icmp sgt i32 %v4_1403c, 0
  br i1 %v8_1404c, label %dec_label_pc_13ff0, label %dec_label_pc_14058

dec_label_pc_14058:                               ; preds = %dec_label_pc_13ff0, %dec_label_pc_14014
  %stack_var_-28.53 = phi i8* [ %v4_13ffc, %dec_label_pc_13ff0 ], [ %stack_var_-28.52, %dec_label_pc_14014 ]
  store i8 0, i8* %stack_var_-28.53, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_1407c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14098 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14098, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_140a0:                               ; preds = %dec_label_pc_12dc0
  %v2_140a4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e90.312 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_140a4, i32* %r0.global-to-local, align 4
  %v4_140b4 = call i32 @write(i32 %v2_140a4, i32* bitcast ([7 x i8]* @global_var_15e90.312 to i32*), i32 6)
  store i32 %v4_140b4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_140e8

dec_label_pc_140c4:                               ; preds = %dec_label_pc_140e8
  %v2_140cc = add i32 %v4_14110, %v4_140fc
  %v4_140d0 = inttoptr i32 %v2_140cc to i8*
  %v1_140d8 = add i32 %v2_140cc, -1
  %v1_140dc = inttoptr i32 %v1_140d8 to i8*
  %v2_140dc = load i8, i8* %v1_140dc, align 1
  %v2_140e0 = icmp ult i8 %v2_140dc, 62
  %v3_140e0 = icmp ne i1 %v2_140e0, true
  store i1 %v3_140e0, i1* %cpsr_c.global-to-local, align 1
  %v9_140e0 = icmp eq i8 %v2_140dc, 62
  store i1 %v9_140e0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_140e0, label %dec_label_pc_14180, label %dec_label_pc_140e8

dec_label_pc_140e8:                               ; preds = %dec_label_pc_140c4, %dec_label_pc_140a0
  %stack_var_-28.54 = phi i8* [ %tmp2137, %dec_label_pc_140a0 ], [ %v4_140d0, %dec_label_pc_140c4 ]
  %v2_140ec = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_140ec, i32* %r0.global-to-local, align 4
  %v4_140fc = ptrtoint i8* %stack_var_-28.54 to i32
  %v1_14104 = sub i32 %v2_12938, %v4_140fc
  store i32 %v4_140fc, i32* %r1.global-to-local, align 4
  %v2_14110 = bitcast i8* %stack_var_-28.54 to i32*
  %v4_14110 = call i32 @read(i32 %v2_140ec, i32* %v2_14110, i32 %v1_14104)
  store i32 %v4_14110, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_1411c = icmp eq i32 %v4_14110, 0
  store i1 %v7_1411c, i1* %cpsr_z.global-to-local, align 1
  %v8_14120 = icmp sgt i32 %v4_14110, 0
  br i1 %v8_14120, label %dec_label_pc_140c4, label %dec_label_pc_14180

dec_label_pc_14180:                               ; preds = %dec_label_pc_140c4, %dec_label_pc_140e8
  %stack_var_-28.55 = phi i8* [ %v4_140d0, %dec_label_pc_140c4 ], [ %stack_var_-28.54, %dec_label_pc_140e8 ]
  store i8 0, i8* %stack_var_-28.55, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_141a4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_141c0 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_141c0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_141c8:                               ; preds = %dec_label_pc_12dc0
  %v2_141cc = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15e98.314 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_141cc, i32* %r0.global-to-local, align 4
  %v4_141dc = call i32 @write(i32 %v2_141cc, i32* bitcast ([7 x i8]* @global_var_15e98.314 to i32*), i32 6)
  store i32 %v4_141dc, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14210

dec_label_pc_141ec:                               ; preds = %dec_label_pc_14210
  %v2_141f4 = add i32 %v4_14238, %v4_14224
  %v4_141f8 = inttoptr i32 %v2_141f4 to i8*
  %v1_14200 = add i32 %v2_141f4, -1
  %v1_14204 = inttoptr i32 %v1_14200 to i8*
  %v2_14204 = load i8, i8* %v1_14204, align 1
  %v2_14208 = icmp ult i8 %v2_14204, 62
  %v3_14208 = icmp ne i1 %v2_14208, true
  store i1 %v3_14208, i1* %cpsr_c.global-to-local, align 1
  %v9_14208 = icmp eq i8 %v2_14204, 62
  store i1 %v9_14208, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14208, label %dec_label_pc_14254, label %dec_label_pc_14210

dec_label_pc_14210:                               ; preds = %dec_label_pc_141ec, %dec_label_pc_141c8
  %stack_var_-28.56 = phi i8* [ %tmp2137, %dec_label_pc_141c8 ], [ %v4_141f8, %dec_label_pc_141ec ]
  %v2_14214 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14214, i32* %r0.global-to-local, align 4
  %v4_14224 = ptrtoint i8* %stack_var_-28.56 to i32
  %v1_1422c = sub i32 %v2_12938, %v4_14224
  store i32 %v4_14224, i32* %r1.global-to-local, align 4
  %v2_14238 = bitcast i8* %stack_var_-28.56 to i32*
  %v4_14238 = call i32 @read(i32 %v2_14214, i32* %v2_14238, i32 %v1_1422c)
  store i32 %v4_14238, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14244 = icmp eq i32 %v4_14238, 0
  store i1 %v7_14244, i1* %cpsr_z.global-to-local, align 1
  %v8_14248 = icmp sgt i32 %v4_14238, 0
  br i1 %v8_14248, label %dec_label_pc_141ec, label %dec_label_pc_14254

dec_label_pc_14254:                               ; preds = %dec_label_pc_141ec, %dec_label_pc_14210
  %stack_var_-28.57 = phi i8* [ %v4_141f8, %dec_label_pc_141ec ], [ %stack_var_-28.56, %dec_label_pc_14210 ]
  store i8 0, i8* %stack_var_-28.57, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14278 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14294 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14294, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_1429c:                               ; preds = %dec_label_pc_12dc0
  %v2_142a0 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ea0.316 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_142a0, i32* %r0.global-to-local, align 4
  %v4_142b0 = call i32 @write(i32 %v2_142a0, i32* bitcast ([7 x i8]* @global_var_15ea0.316 to i32*), i32 6)
  store i32 %v4_142b0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_142e4

dec_label_pc_142c0:                               ; preds = %dec_label_pc_142e4
  %v2_142c8 = add i32 %v4_1430c, %v4_142f8
  %v4_142cc = inttoptr i32 %v2_142c8 to i8*
  %v1_142d4 = add i32 %v2_142c8, -1
  %v1_142d8 = inttoptr i32 %v1_142d4 to i8*
  %v2_142d8 = load i8, i8* %v1_142d8, align 1
  %v2_142dc = icmp ult i8 %v2_142d8, 62
  %v3_142dc = icmp ne i1 %v2_142dc, true
  store i1 %v3_142dc, i1* %cpsr_c.global-to-local, align 1
  %v9_142dc = icmp eq i8 %v2_142d8, 62
  store i1 %v9_142dc, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_142dc, label %dec_label_pc_14328, label %dec_label_pc_142e4

dec_label_pc_142e4:                               ; preds = %dec_label_pc_142c0, %dec_label_pc_1429c
  %stack_var_-28.58 = phi i8* [ %tmp2137, %dec_label_pc_1429c ], [ %v4_142cc, %dec_label_pc_142c0 ]
  %v2_142e8 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_142e8, i32* %r0.global-to-local, align 4
  %v4_142f8 = ptrtoint i8* %stack_var_-28.58 to i32
  %v1_14300 = sub i32 %v2_12938, %v4_142f8
  store i32 %v4_142f8, i32* %r1.global-to-local, align 4
  %v2_1430c = bitcast i8* %stack_var_-28.58 to i32*
  %v4_1430c = call i32 @read(i32 %v2_142e8, i32* %v2_1430c, i32 %v1_14300)
  store i32 %v4_1430c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14318 = icmp eq i32 %v4_1430c, 0
  store i1 %v7_14318, i1* %cpsr_z.global-to-local, align 1
  %v8_1431c = icmp sgt i32 %v4_1430c, 0
  br i1 %v8_1431c, label %dec_label_pc_142c0, label %dec_label_pc_14328

dec_label_pc_14328:                               ; preds = %dec_label_pc_142c0, %dec_label_pc_142e4
  %stack_var_-28.59 = phi i8* [ %v4_142cc, %dec_label_pc_142c0 ], [ %stack_var_-28.58, %dec_label_pc_142e4 ]
  store i8 0, i8* %stack_var_-28.59, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_1434c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14368 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14368, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14370:                               ; preds = %dec_label_pc_12dc0
  %v2_14374 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ea8.318 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14374, i32* %r0.global-to-local, align 4
  %v4_14384 = call i32 @write(i32 %v2_14374, i32* bitcast ([7 x i8]* @global_var_15ea8.318 to i32*), i32 6)
  store i32 %v4_14384, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_143b8

dec_label_pc_14394:                               ; preds = %dec_label_pc_143b8
  %v2_1439c = add i32 %v4_143e0, %v4_143cc
  %v4_143a0 = inttoptr i32 %v2_1439c to i8*
  %v1_143a8 = add i32 %v2_1439c, -1
  %v1_143ac = inttoptr i32 %v1_143a8 to i8*
  %v2_143ac = load i8, i8* %v1_143ac, align 1
  %v2_143b0 = icmp ult i8 %v2_143ac, 62
  %v3_143b0 = icmp ne i1 %v2_143b0, true
  store i1 %v3_143b0, i1* %cpsr_c.global-to-local, align 1
  %v9_143b0 = icmp eq i8 %v2_143ac, 62
  store i1 %v9_143b0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_143b0, label %dec_label_pc_143fc, label %dec_label_pc_143b8

dec_label_pc_143b8:                               ; preds = %dec_label_pc_14394, %dec_label_pc_14370
  %stack_var_-28.60 = phi i8* [ %tmp2137, %dec_label_pc_14370 ], [ %v4_143a0, %dec_label_pc_14394 ]
  %v2_143bc = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_143bc, i32* %r0.global-to-local, align 4
  %v4_143cc = ptrtoint i8* %stack_var_-28.60 to i32
  %v1_143d4 = sub i32 %v2_12938, %v4_143cc
  store i32 %v4_143cc, i32* %r1.global-to-local, align 4
  %v2_143e0 = bitcast i8* %stack_var_-28.60 to i32*
  %v4_143e0 = call i32 @read(i32 %v2_143bc, i32* %v2_143e0, i32 %v1_143d4)
  store i32 %v4_143e0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_143ec = icmp eq i32 %v4_143e0, 0
  store i1 %v7_143ec, i1* %cpsr_z.global-to-local, align 1
  %v8_143f0 = icmp sgt i32 %v4_143e0, 0
  br i1 %v8_143f0, label %dec_label_pc_14394, label %dec_label_pc_143fc

dec_label_pc_143fc:                               ; preds = %dec_label_pc_14394, %dec_label_pc_143b8
  %stack_var_-28.61 = phi i8* [ %v4_143a0, %dec_label_pc_14394 ], [ %stack_var_-28.60, %dec_label_pc_143b8 ]
  store i8 0, i8* %stack_var_-28.61, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14420 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_1443c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_1443c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14444:                               ; preds = %dec_label_pc_12dc0
  %v2_14448 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15eb0.320 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14448, i32* %r0.global-to-local, align 4
  %v4_14458 = call i32 @write(i32 %v2_14448, i32* bitcast ([7 x i8]* @global_var_15eb0.320 to i32*), i32 6)
  store i32 %v4_14458, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_1448c

dec_label_pc_14468:                               ; preds = %dec_label_pc_1448c
  %v2_14470 = add i32 %v4_144b4, %v4_144a0
  %v4_14474 = inttoptr i32 %v2_14470 to i8*
  %v1_1447c = add i32 %v2_14470, -1
  %v1_14480 = inttoptr i32 %v1_1447c to i8*
  %v2_14480 = load i8, i8* %v1_14480, align 1
  %v2_14484 = icmp ult i8 %v2_14480, 62
  %v3_14484 = icmp ne i1 %v2_14484, true
  store i1 %v3_14484, i1* %cpsr_c.global-to-local, align 1
  %v9_14484 = icmp eq i8 %v2_14480, 62
  store i1 %v9_14484, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14484, label %dec_label_pc_144d0, label %dec_label_pc_1448c

dec_label_pc_1448c:                               ; preds = %dec_label_pc_14468, %dec_label_pc_14444
  %stack_var_-28.62 = phi i8* [ %tmp2137, %dec_label_pc_14444 ], [ %v4_14474, %dec_label_pc_14468 ]
  %v2_14490 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14490, i32* %r0.global-to-local, align 4
  %v4_144a0 = ptrtoint i8* %stack_var_-28.62 to i32
  %v1_144a8 = sub i32 %v2_12938, %v4_144a0
  store i32 %v4_144a0, i32* %r1.global-to-local, align 4
  %v2_144b4 = bitcast i8* %stack_var_-28.62 to i32*
  %v4_144b4 = call i32 @read(i32 %v2_14490, i32* %v2_144b4, i32 %v1_144a8)
  store i32 %v4_144b4, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_144c0 = icmp eq i32 %v4_144b4, 0
  store i1 %v7_144c0, i1* %cpsr_z.global-to-local, align 1
  %v8_144c4 = icmp sgt i32 %v4_144b4, 0
  br i1 %v8_144c4, label %dec_label_pc_14468, label %dec_label_pc_144d0

dec_label_pc_144d0:                               ; preds = %dec_label_pc_14468, %dec_label_pc_1448c
  %stack_var_-28.63 = phi i8* [ %v4_14474, %dec_label_pc_14468 ], [ %stack_var_-28.62, %dec_label_pc_1448c ]
  store i8 0, i8* %stack_var_-28.63, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_144f4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14510 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14510, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14518:                               ; preds = %dec_label_pc_12dc0
  %v2_1451c = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15eb8.322 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1451c, i32* %r0.global-to-local, align 4
  %v4_1452c = call i32 @write(i32 %v2_1451c, i32* bitcast ([7 x i8]* @global_var_15eb8.322 to i32*), i32 6)
  store i32 %v4_1452c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14560

dec_label_pc_1453c:                               ; preds = %dec_label_pc_14560
  %v2_14544 = add i32 %v4_14588, %v4_14574
  %v4_14548 = inttoptr i32 %v2_14544 to i8*
  %v1_14550 = add i32 %v2_14544, -1
  %v1_14554 = inttoptr i32 %v1_14550 to i8*
  %v2_14554 = load i8, i8* %v1_14554, align 1
  %v2_14558 = icmp ult i8 %v2_14554, 62
  %v3_14558 = icmp ne i1 %v2_14558, true
  store i1 %v3_14558, i1* %cpsr_c.global-to-local, align 1
  %v9_14558 = icmp eq i8 %v2_14554, 62
  store i1 %v9_14558, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14558, label %dec_label_pc_145a4, label %dec_label_pc_14560

dec_label_pc_14560:                               ; preds = %dec_label_pc_1453c, %dec_label_pc_14518
  %stack_var_-28.64 = phi i8* [ %tmp2137, %dec_label_pc_14518 ], [ %v4_14548, %dec_label_pc_1453c ]
  %v2_14564 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14564, i32* %r0.global-to-local, align 4
  %v4_14574 = ptrtoint i8* %stack_var_-28.64 to i32
  %v1_1457c = sub i32 %v2_12938, %v4_14574
  store i32 %v4_14574, i32* %r1.global-to-local, align 4
  %v2_14588 = bitcast i8* %stack_var_-28.64 to i32*
  %v4_14588 = call i32 @read(i32 %v2_14564, i32* %v2_14588, i32 %v1_1457c)
  store i32 %v4_14588, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14594 = icmp eq i32 %v4_14588, 0
  store i1 %v7_14594, i1* %cpsr_z.global-to-local, align 1
  %v8_14598 = icmp sgt i32 %v4_14588, 0
  br i1 %v8_14598, label %dec_label_pc_1453c, label %dec_label_pc_145a4

dec_label_pc_145a4:                               ; preds = %dec_label_pc_1453c, %dec_label_pc_14560
  %stack_var_-28.65 = phi i8* [ %v4_14548, %dec_label_pc_1453c ], [ %stack_var_-28.64, %dec_label_pc_14560 ]
  store i8 0, i8* %stack_var_-28.65, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_145c8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_145e4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_145e4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_145ec:                               ; preds = %dec_label_pc_12dc0
  %v2_145f0 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ec0.324 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_145f0, i32* %r0.global-to-local, align 4
  %v4_14600 = call i32 @write(i32 %v2_145f0, i32* bitcast ([7 x i8]* @global_var_15ec0.324 to i32*), i32 6)
  store i32 %v4_14600, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14634

dec_label_pc_14610:                               ; preds = %dec_label_pc_14634
  %v2_14618 = add i32 %v4_1465c, %v4_14648
  %v4_1461c = inttoptr i32 %v2_14618 to i8*
  %v1_14624 = add i32 %v2_14618, -1
  %v1_14628 = inttoptr i32 %v1_14624 to i8*
  %v2_14628 = load i8, i8* %v1_14628, align 1
  %v2_1462c = icmp ult i8 %v2_14628, 62
  %v3_1462c = icmp ne i1 %v2_1462c, true
  store i1 %v3_1462c, i1* %cpsr_c.global-to-local, align 1
  %v9_1462c = icmp eq i8 %v2_14628, 62
  store i1 %v9_1462c, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_1462c, label %dec_label_pc_14678, label %dec_label_pc_14634

dec_label_pc_14634:                               ; preds = %dec_label_pc_14610, %dec_label_pc_145ec
  %stack_var_-28.66 = phi i8* [ %tmp2137, %dec_label_pc_145ec ], [ %v4_1461c, %dec_label_pc_14610 ]
  %v2_14638 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14638, i32* %r0.global-to-local, align 4
  %v4_14648 = ptrtoint i8* %stack_var_-28.66 to i32
  %v1_14650 = sub i32 %v2_12938, %v4_14648
  store i32 %v4_14648, i32* %r1.global-to-local, align 4
  %v2_1465c = bitcast i8* %stack_var_-28.66 to i32*
  %v4_1465c = call i32 @read(i32 %v2_14638, i32* %v2_1465c, i32 %v1_14650)
  store i32 %v4_1465c, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14668 = icmp eq i32 %v4_1465c, 0
  store i1 %v7_14668, i1* %cpsr_z.global-to-local, align 1
  %v8_1466c = icmp sgt i32 %v4_1465c, 0
  br i1 %v8_1466c, label %dec_label_pc_14610, label %dec_label_pc_14678

dec_label_pc_14678:                               ; preds = %dec_label_pc_14610, %dec_label_pc_14634
  %stack_var_-28.67 = phi i8* [ %v4_1461c, %dec_label_pc_14610 ], [ %stack_var_-28.66, %dec_label_pc_14634 ]
  store i8 0, i8* %stack_var_-28.67, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_1469c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_146b8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_146b8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_146c0:                               ; preds = %dec_label_pc_12dc0
  %v2_146c4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ec8.326 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_146c4, i32* %r0.global-to-local, align 4
  %v4_146d4 = call i32 @write(i32 %v2_146c4, i32* bitcast ([7 x i8]* @global_var_15ec8.326 to i32*), i32 6)
  store i32 %v4_146d4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14708

dec_label_pc_146e4:                               ; preds = %dec_label_pc_14708
  %v2_146ec = add i32 %v4_14730, %v4_1471c
  %v4_146f0 = inttoptr i32 %v2_146ec to i8*
  %v1_146f8 = add i32 %v2_146ec, -1
  %v1_146fc = inttoptr i32 %v1_146f8 to i8*
  %v2_146fc = load i8, i8* %v1_146fc, align 1
  %v2_14700 = icmp ult i8 %v2_146fc, 62
  %v3_14700 = icmp ne i1 %v2_14700, true
  store i1 %v3_14700, i1* %cpsr_c.global-to-local, align 1
  %v9_14700 = icmp eq i8 %v2_146fc, 62
  store i1 %v9_14700, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14700, label %dec_label_pc_1474c, label %dec_label_pc_14708

dec_label_pc_14708:                               ; preds = %dec_label_pc_146e4, %dec_label_pc_146c0
  %stack_var_-28.68 = phi i8* [ %tmp2137, %dec_label_pc_146c0 ], [ %v4_146f0, %dec_label_pc_146e4 ]
  %v2_1470c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_1470c, i32* %r0.global-to-local, align 4
  %v4_1471c = ptrtoint i8* %stack_var_-28.68 to i32
  %v1_14724 = sub i32 %v2_12938, %v4_1471c
  store i32 %v4_1471c, i32* %r1.global-to-local, align 4
  %v2_14730 = bitcast i8* %stack_var_-28.68 to i32*
  %v4_14730 = call i32 @read(i32 %v2_1470c, i32* %v2_14730, i32 %v1_14724)
  store i32 %v4_14730, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_1473c = icmp eq i32 %v4_14730, 0
  store i1 %v7_1473c, i1* %cpsr_z.global-to-local, align 1
  %v8_14740 = icmp sgt i32 %v4_14730, 0
  br i1 %v8_14740, label %dec_label_pc_146e4, label %dec_label_pc_1474c

dec_label_pc_1474c:                               ; preds = %dec_label_pc_146e4, %dec_label_pc_14708
  %stack_var_-28.69 = phi i8* [ %v4_146f0, %dec_label_pc_146e4 ], [ %stack_var_-28.68, %dec_label_pc_14708 ]
  store i8 0, i8* %stack_var_-28.69, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14770 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_1478c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_1478c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14794:                               ; preds = %dec_label_pc_12dc0
  %v2_14798 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ed0.328 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14798, i32* %r0.global-to-local, align 4
  %v4_147a8 = call i32 @write(i32 %v2_14798, i32* bitcast ([7 x i8]* @global_var_15ed0.328 to i32*), i32 6)
  store i32 %v4_147a8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_147dc

dec_label_pc_147b8:                               ; preds = %dec_label_pc_147dc
  %v2_147c0 = add i32 %v4_14804, %v4_147f0
  %v4_147c4 = inttoptr i32 %v2_147c0 to i8*
  %v1_147cc = add i32 %v2_147c0, -1
  %v1_147d0 = inttoptr i32 %v1_147cc to i8*
  %v2_147d0 = load i8, i8* %v1_147d0, align 1
  %v2_147d4 = icmp ult i8 %v2_147d0, 62
  %v3_147d4 = icmp ne i1 %v2_147d4, true
  store i1 %v3_147d4, i1* %cpsr_c.global-to-local, align 1
  %v9_147d4 = icmp eq i8 %v2_147d0, 62
  store i1 %v9_147d4, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_147d4, label %dec_label_pc_14820, label %dec_label_pc_147dc

dec_label_pc_147dc:                               ; preds = %dec_label_pc_147b8, %dec_label_pc_14794
  %stack_var_-28.70 = phi i8* [ %tmp2137, %dec_label_pc_14794 ], [ %v4_147c4, %dec_label_pc_147b8 ]
  %v2_147e0 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_147e0, i32* %r0.global-to-local, align 4
  %v4_147f0 = ptrtoint i8* %stack_var_-28.70 to i32
  %v1_147f8 = sub i32 %v2_12938, %v4_147f0
  store i32 %v4_147f0, i32* %r1.global-to-local, align 4
  %v2_14804 = bitcast i8* %stack_var_-28.70 to i32*
  %v4_14804 = call i32 @read(i32 %v2_147e0, i32* %v2_14804, i32 %v1_147f8)
  store i32 %v4_14804, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14810 = icmp eq i32 %v4_14804, 0
  store i1 %v7_14810, i1* %cpsr_z.global-to-local, align 1
  %v8_14814 = icmp sgt i32 %v4_14804, 0
  br i1 %v8_14814, label %dec_label_pc_147b8, label %dec_label_pc_14820

dec_label_pc_14820:                               ; preds = %dec_label_pc_147b8, %dec_label_pc_147dc
  %stack_var_-28.71 = phi i8* [ %v4_147c4, %dec_label_pc_147b8 ], [ %stack_var_-28.70, %dec_label_pc_147dc ]
  store i8 0, i8* %stack_var_-28.71, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14844 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14860 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14860, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14868:                               ; preds = %dec_label_pc_12dc0
  %v2_1486c = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ed8.330 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1486c, i32* %r0.global-to-local, align 4
  %v4_1487c = call i32 @write(i32 %v2_1486c, i32* bitcast ([7 x i8]* @global_var_15ed8.330 to i32*), i32 6)
  store i32 %v4_1487c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_148b0

dec_label_pc_1488c:                               ; preds = %dec_label_pc_148b0
  %v2_14894 = add i32 %v4_148d8, %v4_148c4
  %v4_14898 = inttoptr i32 %v2_14894 to i8*
  %v1_148a0 = add i32 %v2_14894, -1
  %v1_148a4 = inttoptr i32 %v1_148a0 to i8*
  %v2_148a4 = load i8, i8* %v1_148a4, align 1
  %v2_148a8 = icmp ult i8 %v2_148a4, 62
  %v3_148a8 = icmp ne i1 %v2_148a8, true
  store i1 %v3_148a8, i1* %cpsr_c.global-to-local, align 1
  %v9_148a8 = icmp eq i8 %v2_148a4, 62
  store i1 %v9_148a8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_148a8, label %dec_label_pc_148f4, label %dec_label_pc_148b0

dec_label_pc_148b0:                               ; preds = %dec_label_pc_1488c, %dec_label_pc_14868
  %stack_var_-28.72 = phi i8* [ %tmp2137, %dec_label_pc_14868 ], [ %v4_14898, %dec_label_pc_1488c ]
  %v2_148b4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_148b4, i32* %r0.global-to-local, align 4
  %v4_148c4 = ptrtoint i8* %stack_var_-28.72 to i32
  %v1_148cc = sub i32 %v2_12938, %v4_148c4
  store i32 %v4_148c4, i32* %r1.global-to-local, align 4
  %v2_148d8 = bitcast i8* %stack_var_-28.72 to i32*
  %v4_148d8 = call i32 @read(i32 %v2_148b4, i32* %v2_148d8, i32 %v1_148cc)
  store i32 %v4_148d8, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_148e4 = icmp eq i32 %v4_148d8, 0
  store i1 %v7_148e4, i1* %cpsr_z.global-to-local, align 1
  %v8_148e8 = icmp sgt i32 %v4_148d8, 0
  br i1 %v8_148e8, label %dec_label_pc_1488c, label %dec_label_pc_148f4

dec_label_pc_148f4:                               ; preds = %dec_label_pc_1488c, %dec_label_pc_148b0
  %stack_var_-28.73 = phi i8* [ %v4_14898, %dec_label_pc_1488c ], [ %stack_var_-28.72, %dec_label_pc_148b0 ]
  store i8 0, i8* %stack_var_-28.73, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14918 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_1491c = load i8, i8* %stack_var_-597, align 1
  %v4_1491c = zext i8 %v3_1491c to i32
  %v1_14920 = add nsw i32 %v4_1491c, -40
  store i32 ptrtoint ([6 x i8]* @global_var_15ee0.332 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_14938 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([6 x i8], [6 x i8]* @global_var_15ee0.332, i32 0, i32 0), i32 %v1_14920)
  store i32 %v7_14938, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14940:                               ; preds = %dec_label_pc_12dc0
  %v2_14944 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ee8.334 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14944, i32* %r0.global-to-local, align 4
  %v4_14954 = call i32 @write(i32 %v2_14944, i32* bitcast ([7 x i8]* @global_var_15ee8.334 to i32*), i32 6)
  store i32 %v4_14954, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14988

dec_label_pc_14964:                               ; preds = %dec_label_pc_14988
  %v2_1496c = add i32 %v4_149b0, %v4_1499c
  %v4_14970 = inttoptr i32 %v2_1496c to i8*
  %v1_14978 = add i32 %v2_1496c, -1
  %v1_1497c = inttoptr i32 %v1_14978 to i8*
  %v2_1497c = load i8, i8* %v1_1497c, align 1
  %v2_14980 = icmp ult i8 %v2_1497c, 62
  %v3_14980 = icmp ne i1 %v2_14980, true
  store i1 %v3_14980, i1* %cpsr_c.global-to-local, align 1
  %v9_14980 = icmp eq i8 %v2_1497c, 62
  store i1 %v9_14980, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14980, label %dec_label_pc_149cc, label %dec_label_pc_14988

dec_label_pc_14988:                               ; preds = %dec_label_pc_14964, %dec_label_pc_14940
  %stack_var_-28.74 = phi i8* [ %tmp2137, %dec_label_pc_14940 ], [ %v4_14970, %dec_label_pc_14964 ]
  %v2_1498c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_1498c, i32* %r0.global-to-local, align 4
  %v4_1499c = ptrtoint i8* %stack_var_-28.74 to i32
  %v1_149a4 = sub i32 %v2_12938, %v4_1499c
  store i32 %v4_1499c, i32* %r1.global-to-local, align 4
  %v2_149b0 = bitcast i8* %stack_var_-28.74 to i32*
  %v4_149b0 = call i32 @read(i32 %v2_1498c, i32* %v2_149b0, i32 %v1_149a4)
  store i32 %v4_149b0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_149bc = icmp eq i32 %v4_149b0, 0
  store i1 %v7_149bc, i1* %cpsr_z.global-to-local, align 1
  %v8_149c0 = icmp sgt i32 %v4_149b0, 0
  br i1 %v8_149c0, label %dec_label_pc_14964, label %dec_label_pc_149cc

dec_label_pc_149cc:                               ; preds = %dec_label_pc_14964, %dec_label_pc_14988
  %stack_var_-28.75 = phi i8* [ %v4_14970, %dec_label_pc_14964 ], [ %stack_var_-28.74, %dec_label_pc_14988 ]
  store i8 0, i8* %stack_var_-28.75, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_149ec = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_14a08 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14a24 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14a40 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14a40, i32* %r0.global-to-local, align 4
  %v3_14a44 = load i8, i8* %stack_var_-597, align 1
  %v4_14a44 = zext i8 %v3_14a44 to i32
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  %v4_14a48 = mul nuw nsw i32 %v4_14a44, 256
  %v3_14a4c = load i8, i8* %stack_var_-598, align 1
  %v4_14a4c = zext i8 %v3_14a4c to i32
  %v2_14a50 = or i32 %v4_14a4c, %v4_14a48
  %v1_14a54 = call float @__asm_vmov(i32 %v2_14a50)
  %v1_14a58 = call double @__asm_vcvt.f64.s32(float %v1_14a54)
  %v1_14a5c = call double @__asm_vldr(i32 0)
  %v2_14a60 = call double @__asm_vmul.f64(double %v1_14a58, double %v1_14a5c)
  %v1_14a64 = call float @__asm_vcvt.f32.f64(double %v2_14a60)
  call void @__asm_vstr(float %v1_14a64, i32 %tmp1878)
  %v4_14a6c = call float @__asm_vldr.3(i32 %tmp1878)
  %v1_14a70 = call double @__asm_vcvt.f64.s32(float %v4_14a6c)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_14a80 = call i32 @__asm_vmov.2(double %v1_14a70)
  %v2_14a80 = sext i32 %v1_14a80 to i64
  %v3_14a80 = bitcast i64 %v2_14a80 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15ef0.337 to i32), i32* %r1.global-to-local, align 4
  %v11_14a88 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15ef0.337, i32 0, i32 0), double %v3_14a80)
  store i32 %v11_14a88, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14a90:                               ; preds = %dec_label_pc_12dc0
  %v2_14a94 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15ef8.340 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14a94, i32* %r0.global-to-local, align 4
  %v4_14aa4 = call i32 @write(i32 %v2_14a94, i32* bitcast ([7 x i8]* @global_var_15ef8.340 to i32*), i32 6)
  store i32 %v4_14aa4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14ad8

dec_label_pc_14ab4:                               ; preds = %dec_label_pc_14ad8
  %v2_14abc = add i32 %v4_14b00, %v4_14aec
  %v4_14ac0 = inttoptr i32 %v2_14abc to i8*
  %v1_14ac8 = add i32 %v2_14abc, -1
  %v1_14acc = inttoptr i32 %v1_14ac8 to i8*
  %v2_14acc = load i8, i8* %v1_14acc, align 1
  %v2_14ad0 = icmp ult i8 %v2_14acc, 62
  %v3_14ad0 = icmp ne i1 %v2_14ad0, true
  store i1 %v3_14ad0, i1* %cpsr_c.global-to-local, align 1
  %v9_14ad0 = icmp eq i8 %v2_14acc, 62
  store i1 %v9_14ad0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14ad0, label %dec_label_pc_14b1c, label %dec_label_pc_14ad8

dec_label_pc_14ad8:                               ; preds = %dec_label_pc_14ab4, %dec_label_pc_14a90
  %stack_var_-28.76 = phi i8* [ %tmp2137, %dec_label_pc_14a90 ], [ %v4_14ac0, %dec_label_pc_14ab4 ]
  %v2_14adc = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14adc, i32* %r0.global-to-local, align 4
  %v4_14aec = ptrtoint i8* %stack_var_-28.76 to i32
  %v1_14af4 = sub i32 %v2_12938, %v4_14aec
  store i32 %v4_14aec, i32* %r1.global-to-local, align 4
  %v2_14b00 = bitcast i8* %stack_var_-28.76 to i32*
  %v4_14b00 = call i32 @read(i32 %v2_14adc, i32* %v2_14b00, i32 %v1_14af4)
  store i32 %v4_14b00, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14b0c = icmp eq i32 %v4_14b00, 0
  store i1 %v7_14b0c, i1* %cpsr_z.global-to-local, align 1
  %v8_14b10 = icmp sgt i32 %v4_14b00, 0
  br i1 %v8_14b10, label %dec_label_pc_14ab4, label %dec_label_pc_14b1c

dec_label_pc_14b1c:                               ; preds = %dec_label_pc_14ab4, %dec_label_pc_14ad8
  %stack_var_-28.77 = phi i8* [ %v4_14ac0, %dec_label_pc_14ab4 ], [ %stack_var_-28.76, %dec_label_pc_14ad8 ]
  store i8 0, i8* %stack_var_-28.77, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_14b3c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_14b58 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14b74 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14b90 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14b90, i32* %r0.global-to-local, align 4
  %v3_14b94 = load i8, i8* %stack_var_-597, align 1
  %v4_14b94 = zext i8 %v3_14b94 to i32
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  %v4_14b98 = mul nuw nsw i32 %v4_14b94, 256
  %v3_14b9c = load i8, i8* %stack_var_-598, align 1
  %v4_14b9c = zext i8 %v3_14b9c to i32
  %v2_14ba0 = or i32 %v4_14b9c, %v4_14b98
  %v1_14ba4 = call float @__asm_vmov(i32 %v2_14ba0)
  %v1_14ba8 = call double @__asm_vcvt.f64.s32(float %v1_14ba4)
  %v1_14bac = call double @__asm_vldr(i32 0)
  %v2_14bb0 = call double @__asm_vmul.f64(double %v1_14ba8, double %v1_14bac)
  %v1_14bb4 = call float @__asm_vcvt.f32.f64(double %v2_14bb0)
  call void @__asm_vstr(float %v1_14bb4, i32 %tmp1877)
  %v4_14bbc = call float @__asm_vldr.3(i32 %tmp1877)
  %v1_14bc0 = call double @__asm_vcvt.f64.s32(float %v4_14bbc)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_14bd0 = call i32 @__asm_vmov.2(double %v1_14bc0)
  %v2_14bd0 = sext i32 %v1_14bd0 to i64
  %v3_14bd0 = bitcast i64 %v2_14bd0 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15f00.343 to i32), i32* %r1.global-to-local, align 4
  %v11_14bd8 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15f00.343, i32 0, i32 0), double %v3_14bd0)
  store i32 %v11_14bd8, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14be0:                               ; preds = %dec_label_pc_12dc0
  %v2_14be4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15f08.345 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14be4, i32* %r0.global-to-local, align 4
  %v4_14bf4 = call i32 @write(i32 %v2_14be4, i32* bitcast ([7 x i8]* @global_var_15f08.345 to i32*), i32 6)
  store i32 %v4_14bf4, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14c28

dec_label_pc_14c04:                               ; preds = %dec_label_pc_14c28
  %v2_14c0c = add i32 %v4_14c50, %v4_14c3c
  %v4_14c10 = inttoptr i32 %v2_14c0c to i8*
  %v1_14c18 = add i32 %v2_14c0c, -1
  %v1_14c1c = inttoptr i32 %v1_14c18 to i8*
  %v2_14c1c = load i8, i8* %v1_14c1c, align 1
  %v2_14c20 = icmp ult i8 %v2_14c1c, 62
  %v3_14c20 = icmp ne i1 %v2_14c20, true
  store i1 %v3_14c20, i1* %cpsr_c.global-to-local, align 1
  %v9_14c20 = icmp eq i8 %v2_14c1c, 62
  store i1 %v9_14c20, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14c20, label %dec_label_pc_14c6c, label %dec_label_pc_14c28

dec_label_pc_14c28:                               ; preds = %dec_label_pc_14c04, %dec_label_pc_14be0
  %stack_var_-28.78 = phi i8* [ %tmp2137, %dec_label_pc_14be0 ], [ %v4_14c10, %dec_label_pc_14c04 ]
  %v2_14c2c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14c2c, i32* %r0.global-to-local, align 4
  %v4_14c3c = ptrtoint i8* %stack_var_-28.78 to i32
  %v1_14c44 = sub i32 %v2_12938, %v4_14c3c
  store i32 %v4_14c3c, i32* %r1.global-to-local, align 4
  %v2_14c50 = bitcast i8* %stack_var_-28.78 to i32*
  %v4_14c50 = call i32 @read(i32 %v2_14c2c, i32* %v2_14c50, i32 %v1_14c44)
  store i32 %v4_14c50, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14c5c = icmp eq i32 %v4_14c50, 0
  store i1 %v7_14c5c, i1* %cpsr_z.global-to-local, align 1
  %v8_14c60 = icmp sgt i32 %v4_14c50, 0
  br i1 %v8_14c60, label %dec_label_pc_14c04, label %dec_label_pc_14c6c

dec_label_pc_14c6c:                               ; preds = %dec_label_pc_14c04, %dec_label_pc_14c28
  %stack_var_-28.79 = phi i8* [ %v4_14c10, %dec_label_pc_14c04 ], [ %stack_var_-28.78, %dec_label_pc_14c28 ]
  store i8 0, i8* %stack_var_-28.79, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_14c8c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_14ca8 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14cc4 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14ce0 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14ce0, i32* %r0.global-to-local, align 4
  %v3_14ce4 = load i8, i8* %stack_var_-597, align 1
  %v4_14ce4 = zext i8 %v3_14ce4 to i32
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  %v4_14ce8 = mul nuw nsw i32 %v4_14ce4, 256
  %v3_14cec = load i8, i8* %stack_var_-598, align 1
  %v4_14cec = zext i8 %v3_14cec to i32
  %v2_14cf0 = or i32 %v4_14cec, %v4_14ce8
  %v1_14cf4 = call float @__asm_vmov(i32 %v2_14cf0)
  %v1_14cf8 = call double @__asm_vcvt.f64.s32(float %v1_14cf4)
  %v1_14cfc = call double @__asm_vldr(i32 0)
  %v2_14d00 = call double @__asm_vmul.f64(double %v1_14cf8, double %v1_14cfc)
  %v1_14d04 = call float @__asm_vcvt.f32.f64(double %v2_14d00)
  call void @__asm_vstr(float %v1_14d04, i32 %tmp1876)
  %v4_14d0c = call float @__asm_vldr.3(i32 %tmp1876)
  %v1_14d10 = call double @__asm_vcvt.f64.s32(float %v4_14d0c)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_14d20 = call i32 @__asm_vmov.2(double %v1_14d10)
  %v2_14d20 = sext i32 %v1_14d20 to i64
  %v3_14d20 = bitcast i64 %v2_14d20 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15f10.347 to i32), i32* %r1.global-to-local, align 4
  %v11_14d28 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15f10.347, i32 0, i32 0), double %v3_14d20)
  store i32 %v11_14d28, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14d30:                               ; preds = %dec_label_pc_12dc0
  %v2_14d34 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15f18.349 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14d34, i32* %r0.global-to-local, align 4
  %v4_14d44 = call i32 @write(i32 %v2_14d34, i32* bitcast ([7 x i8]* @global_var_15f18.349 to i32*), i32 6)
  store i32 %v4_14d44, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14d78

dec_label_pc_14d54:                               ; preds = %dec_label_pc_14d78
  %v2_14d5c = add i32 %v4_14da0, %v4_14d8c
  %v4_14d60 = inttoptr i32 %v2_14d5c to i8*
  %v1_14d68 = add i32 %v2_14d5c, -1
  %v1_14d6c = inttoptr i32 %v1_14d68 to i8*
  %v2_14d6c = load i8, i8* %v1_14d6c, align 1
  %v2_14d70 = icmp ult i8 %v2_14d6c, 62
  %v3_14d70 = icmp ne i1 %v2_14d70, true
  store i1 %v3_14d70, i1* %cpsr_c.global-to-local, align 1
  %v9_14d70 = icmp eq i8 %v2_14d6c, 62
  store i1 %v9_14d70, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14d70, label %dec_label_pc_14de4, label %dec_label_pc_14d78

dec_label_pc_14d78:                               ; preds = %dec_label_pc_14d54, %dec_label_pc_14d30
  %stack_var_-28.80 = phi i8* [ %tmp2137, %dec_label_pc_14d30 ], [ %v4_14d60, %dec_label_pc_14d54 ]
  %v2_14d7c = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14d7c, i32* %r0.global-to-local, align 4
  %v4_14d8c = ptrtoint i8* %stack_var_-28.80 to i32
  %v1_14d94 = sub i32 %v2_12938, %v4_14d8c
  store i32 %v4_14d8c, i32* %r1.global-to-local, align 4
  %v2_14da0 = bitcast i8* %stack_var_-28.80 to i32*
  %v4_14da0 = call i32 @read(i32 %v2_14d7c, i32* %v2_14da0, i32 %v1_14d94)
  store i32 %v4_14da0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14dac = icmp eq i32 %v4_14da0, 0
  store i1 %v7_14dac, i1* %cpsr_z.global-to-local, align 1
  %v8_14db0 = icmp sgt i32 %v4_14da0, 0
  br i1 %v8_14db0, label %dec_label_pc_14d54, label %dec_label_pc_14de4

dec_label_pc_14de4:                               ; preds = %dec_label_pc_14d54, %dec_label_pc_14d78
  %stack_var_-28.81 = phi i8* [ %v4_14d60, %dec_label_pc_14d54 ], [ %stack_var_-28.80, %dec_label_pc_14d78 ]
  store i8 0, i8* %stack_var_-28.81, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_1204c, i32* %r0.global-to-local, align 4
  %v9_14e04 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2145, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-600)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12030, i32* %r0.global-to-local, align 4
  %v9_14e20 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2144, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-599)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_14e3c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14e58 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_14e58, i32* %r0.global-to-local, align 4
  %v3_14e5c = load i8, i8* %stack_var_-597, align 1
  %v4_14e5c = zext i8 %v3_14e5c to i32
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  %v4_14e60 = mul nuw nsw i32 %v4_14e5c, 256
  %v3_14e64 = load i8, i8* %stack_var_-598, align 1
  %v4_14e64 = zext i8 %v3_14e64 to i32
  %v2_14e68 = or i32 %v4_14e64, %v4_14e60
  %v1_14e6c = call float @__asm_vmov(i32 %v2_14e68)
  %v1_14e70 = call double @__asm_vcvt.f64.s32(float %v1_14e6c)
  %v1_14e74 = call double @__asm_vldr(i32 0)
  %v2_14e78 = call double @__asm_vmul.f64(double %v1_14e70, double %v1_14e74)
  %v1_14e7c = call float @__asm_vcvt.f32.f64(double %v2_14e78)
  call void @__asm_vstr(float %v1_14e7c, i32 %tmp1875)
  %v4_14e84 = call float @__asm_vldr.3(i32 %tmp1875)
  %v1_14e88 = call double @__asm_vcvt.f64.s32(float %v4_14e84)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_14e98 = call i32 @__asm_vmov.2(double %v1_14e88)
  %v2_14e98 = sext i32 %v1_14e98 to i64
  %v3_14e98 = bitcast i64 %v2_14e98 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15f20.352 to i32), i32* %r1.global-to-local, align 4
  %v11_14ea0 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15f20.352, i32 0, i32 0), double %v3_14e98)
  store i32 %v11_14ea0, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14ea8:                               ; preds = %dec_label_pc_12dc0
  %v2_14eac = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15f28.355 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14eac, i32* %r0.global-to-local, align 4
  %v4_14ebc = call i32 @write(i32 %v2_14eac, i32* bitcast ([7 x i8]* @global_var_15f28.355 to i32*), i32 6)
  store i32 %v4_14ebc, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14ef0

dec_label_pc_14ecc:                               ; preds = %dec_label_pc_14ef0
  %v2_14ed4 = add i32 %v4_14f18, %v4_14f04
  %v4_14ed8 = inttoptr i32 %v2_14ed4 to i8*
  %v1_14ee0 = add i32 %v2_14ed4, -1
  %v1_14ee4 = inttoptr i32 %v1_14ee0 to i8*
  %v2_14ee4 = load i8, i8* %v1_14ee4, align 1
  %v2_14ee8 = icmp ult i8 %v2_14ee4, 62
  %v3_14ee8 = icmp ne i1 %v2_14ee8, true
  store i1 %v3_14ee8, i1* %cpsr_c.global-to-local, align 1
  %v9_14ee8 = icmp eq i8 %v2_14ee4, 62
  store i1 %v9_14ee8, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14ee8, label %dec_label_pc_14f34, label %dec_label_pc_14ef0

dec_label_pc_14ef0:                               ; preds = %dec_label_pc_14ecc, %dec_label_pc_14ea8
  %stack_var_-28.82 = phi i8* [ %tmp2137, %dec_label_pc_14ea8 ], [ %v4_14ed8, %dec_label_pc_14ecc ]
  %v2_14ef4 = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14ef4, i32* %r0.global-to-local, align 4
  %v4_14f04 = ptrtoint i8* %stack_var_-28.82 to i32
  %v1_14f0c = sub i32 %v2_12938, %v4_14f04
  store i32 %v4_14f04, i32* %r1.global-to-local, align 4
  %v2_14f18 = bitcast i8* %stack_var_-28.82 to i32*
  %v4_14f18 = call i32 @read(i32 %v2_14ef4, i32* %v2_14f18, i32 %v1_14f0c)
  store i32 %v4_14f18, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14f24 = icmp eq i32 %v4_14f18, 0
  store i1 %v7_14f24, i1* %cpsr_z.global-to-local, align 1
  %v8_14f28 = icmp sgt i32 %v4_14f18, 0
  br i1 %v8_14f28, label %dec_label_pc_14ecc, label %dec_label_pc_14f34

dec_label_pc_14f34:                               ; preds = %dec_label_pc_14ecc, %dec_label_pc_14ef0
  %stack_var_-28.83 = phi i8* [ %v4_14ed8, %dec_label_pc_14ecc ], [ %stack_var_-28.82, %dec_label_pc_14ef0 ]
  store i8 0, i8* %stack_var_-28.83, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_14f58 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  %v3_14f5c = load i8, i8* %stack_var_-597, align 1
  %v4_14f5c = zext i8 %v3_14f5c to i32
  %v1_14f60 = add nsw i32 %v4_14f5c, -40
  store i32 ptrtoint ([5 x i8]* @global_var_15f30.358 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v7_14f78 = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @global_var_15f30.358, i32 0, i32 0), i32 %v1_14f60)
  store i32 %v7_14f78, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_14f80:                               ; preds = %dec_label_pc_12dc0
  %v2_14f84 = load i32, i32* @global_var_272e0.120, align 4
  store i32 ptrtoint ([7 x i8]* @global_var_15f38.360 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_14f84, i32* %r0.global-to-local, align 4
  %v4_14f94 = call i32 @write(i32 %v2_14f84, i32* bitcast ([7 x i8]* @global_var_15f38.360 to i32*), i32 6)
  store i32 %v4_14f94, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_14fc8

dec_label_pc_14fa4:                               ; preds = %dec_label_pc_14fc8
  %v2_14fac = add i32 %v4_14ff0, %v4_14fdc
  %v4_14fb0 = inttoptr i32 %v2_14fac to i8*
  %v1_14fb8 = add i32 %v2_14fac, -1
  %v1_14fbc = inttoptr i32 %v1_14fb8 to i8*
  %v2_14fbc = load i8, i8* %v1_14fbc, align 1
  %v2_14fc0 = icmp ult i8 %v2_14fbc, 62
  %v3_14fc0 = icmp ne i1 %v2_14fc0, true
  store i1 %v3_14fc0, i1* %cpsr_c.global-to-local, align 1
  %v9_14fc0 = icmp eq i8 %v2_14fbc, 62
  store i1 %v9_14fc0, i1* %cpsr_z.global-to-local, align 1
  br i1 %v9_14fc0, label %dec_label_pc_1500c, label %dec_label_pc_14fc8

dec_label_pc_14fc8:                               ; preds = %dec_label_pc_14fa4, %dec_label_pc_14f80
  %stack_var_-28.84 = phi i8* [ %tmp2137, %dec_label_pc_14f80 ], [ %v4_14fb0, %dec_label_pc_14fa4 ]
  %v2_14fcc = load i32, i32* @global_var_272e0.120, align 4
  store i32 %v2_14fcc, i32* %r0.global-to-local, align 4
  %v4_14fdc = ptrtoint i8* %stack_var_-28.84 to i32
  %v1_14fe4 = sub i32 %v2_12938, %v4_14fdc
  store i32 %v4_14fdc, i32* %r1.global-to-local, align 4
  %v2_14ff0 = bitcast i8* %stack_var_-28.84 to i32*
  %v4_14ff0 = call i32 @read(i32 %v2_14fcc, i32* %v2_14ff0, i32 %v1_14fe4)
  store i32 %v4_14ff0, i32* %r0.global-to-local, align 4
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  %v7_14ffc = icmp eq i32 %v4_14ff0, 0
  store i1 %v7_14ffc, i1* %cpsr_z.global-to-local, align 1
  %v8_15000 = icmp sgt i32 %v4_14ff0, 0
  br i1 %v8_15000, label %dec_label_pc_14fa4, label %dec_label_pc_1500c

dec_label_pc_1500c:                               ; preds = %dec_label_pc_14fa4, %dec_label_pc_14fc8
  %stack_var_-28.85 = phi i8* [ %v4_14fb0, %dec_label_pc_14fa4 ], [ %stack_var_-28.84, %dec_label_pc_14fc8 ]
  store i8 0, i8* %stack_var_-28.85, align 1
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_12014, i32* %r0.global-to-local, align 4
  %v9_15030 = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2143, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-598)
  store i32 ptrtoint ([7 x i8]* @global_var_15c40.192 to i32), i32* %r1.global-to-local, align 4
  store i32 %v2_11ff8, i32* %r0.global-to-local, align 4
  %v9_1504c = call i32 (i8*, i8*, ...) @sscanf(i8* %tmp2142, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15c40.192, i32 0, i32 0), i8* nonnull %stack_var_-597)
  store i32 %v9_1504c, i32* %r0.global-to-local, align 4
  %v3_15050 = load i8, i8* %stack_var_-597, align 1
  %v4_15050 = zext i8 %v3_15050 to i32
  store i1 false, i1* %cpsr_c.global-to-local, align 1
  %v4_15054 = mul nuw nsw i32 %v4_15050, 256
  %v3_15058 = load i8, i8* %stack_var_-598, align 1
  %v4_15058 = zext i8 %v3_15058 to i32
  %v2_1505c = or i32 %v4_15058, %v4_15054
  %v1_15060 = call float @__asm_vmov(i32 %v2_1505c)
  %v1_15064 = call double @__asm_vcvt.f64.s32(float %v1_15060)
  %v1_15068 = call double @__asm_vldr(i32 -1717986918)
  %v2_1506c = call double @__asm_vmul.f64(double %v1_15064, double %v1_15068)
  %v1_15070 = call double @__asm_vldr(i32 0)
  %v2_15074 = call double @__asm_vsub.f64(double %v2_1506c, double %v1_15070)
  store i32 %v2_150ac, i32* %r0.global-to-local, align 4
  %v1_15084 = call i32 @__asm_vmov.2(double %v2_15074)
  %v2_15084 = sext i32 %v1_15084 to i64
  %v3_15084 = bitcast i64 %v2_15084 to double
  store i32 ptrtoint ([7 x i8]* @global_var_15f40.364 to i32), i32* %r1.global-to-local, align 4
  %v11_1508c = call i32 (i8*, i8*, ...) @sprintf(i8* %tmp2167, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_15f40.364, i32 0, i32 0), double %v3_15084)
  store i32 %v11_1508c, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15158.preheader

dec_label_pc_15158.preheader:                     ; preds = %dec_label_pc_12dc0, %dec_label_pc_1500c, %dec_label_pc_14f34, %dec_label_pc_14de4, %dec_label_pc_14c6c, %dec_label_pc_14b1c, %dec_label_pc_149cc, %dec_label_pc_148f4, %dec_label_pc_14820, %dec_label_pc_1474c, %dec_label_pc_14678, %dec_label_pc_145a4, %dec_label_pc_144d0, %dec_label_pc_143fc, %dec_label_pc_14328, %dec_label_pc_14254, %dec_label_pc_14180, %dec_label_pc_14058, %dec_label_pc_13f84, %dec_label_pc_13ec4, %dec_label_pc_13e0c, %dec_label_pc_13d28, %dec_label_pc_13c18, %dec_label_pc_13b40, %dec_label_pc_13a60, %dec_label_pc_13988, %dec_label_pc_13804, %dec_label_pc_13730, %dec_label_pc_135c4, %dec_label_pc_134d8, %dec_label_pc_13384, %dec_label_pc_13298, %dec_label_pc_131ac, %dec_label_pc_130d4, %dec_label_pc_12ff0
  %stack_var_-20.0.ph = phi i32 [ 1, %dec_label_pc_12ff0 ], [ 1, %dec_label_pc_130d4 ], [ 1, %dec_label_pc_131ac ], [ 1, %dec_label_pc_13298 ], [ 1, %dec_label_pc_13384 ], [ 1, %dec_label_pc_134d8 ], [ 1, %dec_label_pc_135c4 ], [ 2, %dec_label_pc_13730 ], [ 1, %dec_label_pc_13804 ], [ 1, %dec_label_pc_13988 ], [ 1, %dec_label_pc_13a60 ], [ 1, %dec_label_pc_13b40 ], [ 1, %dec_label_pc_13c18 ], [ 1, %dec_label_pc_13d28 ], [ 1, %dec_label_pc_13e0c ], [ 1, %dec_label_pc_13ec4 ], [ 1, %dec_label_pc_13f84 ], [ 1, %dec_label_pc_14058 ], [ 1, %dec_label_pc_14180 ], [ 1, %dec_label_pc_14254 ], [ 1, %dec_label_pc_14328 ], [ 1, %dec_label_pc_143fc ], [ 1, %dec_label_pc_144d0 ], [ 1, %dec_label_pc_145a4 ], [ 1, %dec_label_pc_14678 ], [ 1, %dec_label_pc_1474c ], [ 1, %dec_label_pc_148f4 ], [ 1, %dec_label_pc_14820 ], [ 1, %dec_label_pc_14f34 ], [ 1, %dec_label_pc_1500c ], [ 1, %dec_label_pc_14de4 ], [ 1, %dec_label_pc_14c6c ], [ 1, %dec_label_pc_14b1c ], [ 1, %dec_label_pc_149cc ], [ 1, %dec_label_pc_12dc0 ]
  br label %dec_label_pc_15158

dec_label_pc_150a4:                               ; preds = %dec_label_pc_15158
  %tmp2173 = and i32 %storemerge52, 67108864
  %v3_150b4 = icmp ne i32 %tmp2173, 0
  store i1 %v3_150b4, i1* %cpsr_c.global-to-local, align 1
  %v4_150b4 = mul i32 %storemerge52, 64
  %v2_150b8 = add i32 %v4_150b4, %v2_150ac
  %v1_150bc = inttoptr i32 %v2_150b8 to i8*
  store i32 %v2_150b8, i32* %r1.global-to-local, align 4
  store i32 ptrtoint ([12 x i8]* @global_var_15f48.366 to i32), i32* %r0.global-to-local, align 4
  %v6_150c4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([12 x i8], [12 x i8]* @global_var_15f48.366, i32 0, i32 0), i8* %v1_150bc)
  %v2_150cc = load i32, i32* @global_var_274e8.126, align 4
  store i32 %v2_150cc, i32* %r4.global-to-local, align 4
  store i32 %v2_150b8, i32* %r5.global-to-local, align 4
  store i1 %v3_150b4, i1* %cpsr_c.global-to-local, align 1
  store i32 %v2_150b8, i32* %r0.global-to-local, align 4
  %v3_15104 = call i32 @strlen(i8* %v1_150bc)
  %v2_15110 = load i32, i32* @global_var_270a8.369, align 4
  store i32 %v2_150b8, i32* %r1.global-to-local, align 4
  %v0_15128 = load i32, i32* %r4.global-to-local, align 4
  store i32 %v0_15128, i32* %r0.global-to-local, align 4
  %v2_1512c = inttoptr i32 %v2_150b8 to i32*
  %v9_1512c = call i32 @sendto(i32 %v0_15128, i32* %v2_1512c, i32 %v3_15104, i32 0, %sockaddr* bitcast (%sockaddr** @global_var_272d0.130 to %sockaddr*), i32 %v2_15110)
  store i32 %v9_1512c, i32* %r0.global-to-local, align 4
  %v2_15134 = icmp eq i32 %v9_1512c, -1
  store i1 %v2_15134, i1* %cpsr_c.global-to-local, align 1
  store i1 %v2_15134, i1* %cpsr_z.global-to-local, align 1
  %v1_15150 = add nuw nsw i32 %storemerge52, 1
  br i1 %v2_15134, label %dec_label_pc_1513c, label %dec_label_pc_15158

dec_label_pc_1513c:                               ; preds = %dec_label_pc_150a4
  store i32 ptrtoint (i8** @global_var_15f54.372 to i32), i32* %r0.global-to-local, align 4
  %v3_15140 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_15f54.372 to i8*))
  store i32 ptrtoint ([9 x i8]* @global_var_15f6c.374 to i32), i32* %r0.global-to-local, align 4
  %v3_15148 = call i32 @die(i8* getelementptr inbounds ([9 x i8], [9 x i8]* @global_var_15f6c.374, i32 0, i32 0))
  unreachable

dec_label_pc_15158:                               ; preds = %dec_label_pc_150a4, %dec_label_pc_15158.preheader
  %storemerge52 = phi i32 [ %v1_15150, %dec_label_pc_150a4 ], [ 0, %dec_label_pc_15158.preheader ]
  %v3_15160 = icmp ult i32 %storemerge52, %stack_var_-20.0.ph
  %v4_15160 = icmp ne i1 %v3_15160, true
  store i1 %v4_15160, i1* %cpsr_c.global-to-local, align 1
  %v10_15160 = icmp eq i32 %storemerge52, %stack_var_-20.0.ph
  store i1 %v10_15160, i1* %cpsr_z.global-to-local, align 1
  %v5_15164 = icmp slt i32 %storemerge52, %stack_var_-20.0.ph
  br i1 %v5_15164, label %dec_label_pc_150a4, label %dec_label_pc_15168.loopexit

dec_label_pc_15168.loopexit:                      ; preds = %dec_label_pc_15158
  store i1 true, i1* %cpsr_c.global-to-local, align 1
  store i1 true, i1* %cpsr_z.global-to-local, align 1
  br label %dec_label_pc_12d20

dec_label_pc_15174:                               ; preds = %dec_label_pc_15168.preheader
  store i32 0, i32* %r0.global-to-local, align 4
  %v2_15180 = load i32, i32* %stack_var_-16, align 4
  store i32 %v2_15180, i32* %r4.global-to-local, align 4
  store i32 %v6_10b10, i32* %r5.global-to-local, align 4
  store i32 %v9_10b10, i32* %fp.global-to-local, align 4
  ret i32 0
}

define i32 @SerialConnection(i32 %arg1) local_unnamed_addr {
dec_label_pc_151d4:
  %r0.global-to-local = alloca i32, align 4
  store i32 %arg1, i32* %r0.global-to-local, align 4
  %stack_var_-72 = alloca i32, align 4
  %v0_151e0 = load i32, i32* %r0.global-to-local, align 4
  %v1_151ec = inttoptr i32 %v0_151e0 to i8*
  %v3_151ec = call i32 (i8*, i32, ...) @open(i8* %v1_151ec, i32 258)
  store i32 %v3_151ec, i32* %r0.global-to-local, align 4
  %v2_151f8 = icmp eq i32 %v3_151ec, -1
  br i1 %v2_151f8, label %dec_label_pc_15310, label %dec_label_pc_15208

dec_label_pc_15208:                               ; preds = %dec_label_pc_151d4
  store i32 %v3_151ec, i32* %r0.global-to-local, align 4
  %v2_15214 = call i32 (i32, i32, ...) @fcntl(i32 %v3_151ec, i32 4)
  %v2_15218 = ptrtoint i32* %stack_var_-72 to i32
  %tmp32 = bitcast i32* %stack_var_-72 to %termios*
  store i32 %v3_151ec, i32* %r0.global-to-local, align 4
  %v4_15224 = call i32 @tcgetattr(i32 %v3_151ec, %termios* %tmp32)
  store i32 %v2_15218, i32* %r0.global-to-local, align 4
  %v4_15234 = call i32 @cfsetispeed(%termios* %tmp32, i32 15)
  store i32 %v2_15218, i32* %r0.global-to-local, align 4
  %v4_15244 = call i32 @cfsetospeed(%termios* %tmp32, i32 15)
  %v3_152a8 = load i32, i32* %stack_var_-72, align 4
  %v1_152c8 = and i32 %v3_152a8, -16209
  store i32 %v1_152c8, i32* %stack_var_-72, align 4
  store i32 %v3_151ec, i32* %r0.global-to-local, align 4
  %v2_152f4 = call i32 @tcflush(i32 %v3_151ec, i32 0)
  store i32 %v3_151ec, i32* %r0.global-to-local, align 4
  %v5_15308 = call i32 @tcsetattr(i32 %v3_151ec, i32 0, %termios* %tmp32)
  store i32 %v5_15308, i32* %r0.global-to-local, align 4
  br label %dec_label_pc_15310

dec_label_pc_15310:                               ; preds = %dec_label_pc_151d4, %dec_label_pc_15208
  %storemerge = phi i32 [ %v3_151ec, %dec_label_pc_15208 ], [ -1, %dec_label_pc_151d4 ]
  store i32 %storemerge, i32* %r0.global-to-local, align 4
  ret i32 %storemerge
}

declare i8* @strstr(i8*, i8*) local_unnamed_addr

declare i32 @inet_aton(i8*, %in_addr*) local_unnamed_addr

declare i32 @printf(i8*, ...) local_unnamed_addr

declare %_IO_FILE* @fopen(i8*, i8*) local_unnamed_addr

declare i32 @read(i32, i32*, i32) local_unnamed_addr

declare i32 @tcflush(i32, i32) local_unnamed_addr

declare i8* @fgets(i8*, i32, %_IO_FILE*) local_unnamed_addr

declare i16 @htons(i16) local_unnamed_addr

declare void @perror(i8*) local_unnamed_addr

declare i32 @cfsetospeed(%termios*, i32) local_unnamed_addr

declare i32 @fwrite(i32*, i32, i32, %_IO_FILE*) local_unnamed_addr

declare i32 @ioctl(i32, i32, ...) local_unnamed_addr

declare i32 @tcsetattr(i32, i32, %termios*) local_unnamed_addr

declare i32 @puts(i8*) local_unnamed_addr

declare i32 @open(i8*, i32, ...) local_unnamed_addr

declare void @exit(i32) local_unnamed_addr

declare i32 @strlen(i8*) local_unnamed_addr

declare i32 @fprintf(%_IO_FILE*, i8*, ...) local_unnamed_addr

declare i32 @cfsetispeed(%termios*, i32) local_unnamed_addr

declare i32 @fcntl(i32, i32, ...) local_unnamed_addr

declare i32 @sscanf(i8*, i8*, ...) local_unnamed_addr

declare i32* @memset(i32*, i32, i32) local_unnamed_addr

declare i8* @strncpy(i8*, i8*, i32) local_unnamed_addr

declare i32 @write(i32, i32*, i32) local_unnamed_addr

declare i32 @strtoimax(i8*, i8**, i32) local_unnamed_addr

declare i32 @fclose(%_IO_FILE*) local_unnamed_addr

declare i8* @strtok(i8*, i8*) local_unnamed_addr

declare i32 @sendto(i32, i32*, i32, i32, %sockaddr*, i32) local_unnamed_addr

declare i32 @fputc(i32, %_IO_FILE*) local_unnamed_addr

declare i32 @sprintf(i8*, i8*, ...) local_unnamed_addr

declare i32 @socket(i32, i32, i32) local_unnamed_addr

declare i32 @close(i32) local_unnamed_addr

declare i32 @tcgetattr(i32, %termios*) local_unnamed_addr

declare float @__asm_vmov(i32) local_unnamed_addr

declare double @__asm_vcvt.f64.s32(float) local_unnamed_addr

declare double @__asm_vldr(i32) local_unnamed_addr

declare double @__asm_vdiv.f64(double, double) local_unnamed_addr

declare i32 @__asm_vmov.2(double) local_unnamed_addr

declare double @__asm_vsub.f64(double, double) local_unnamed_addr

declare float @__asm_vcvt.f32.s32(float) local_unnamed_addr

declare void @__asm_vstr(float, i32) local_unnamed_addr

declare float @__asm_vldr.3(i32) local_unnamed_addr

declare void @__asm_vcmpe.f32(float, i32) local_unnamed_addr

declare void @__asm_vmrs(i32, i32) local_unnamed_addr

declare double @__asm_vmul.f64(double, double) local_unnamed_addr

declare float @__asm_vcvt.f32.f64(double) local_unnamed_addr

declare i32 @__decompiler_undefined_function_0() local_unnamed_addr

declare i8 @__decompiler_undefined_function_9() local_unnamed_addr
