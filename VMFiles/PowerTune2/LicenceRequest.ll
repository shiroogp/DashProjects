source_filename = "test"
target datalayout = "e-p:32:32:32-f80:32:32"

%_IO_FILE = type { i32 }

@global_var_10a0c.39 = constant [83 x i8] c"**********************************************************************************\00"
@global_var_10a60.41 = constant [83 x i8] c"*                            PowerTune UDP Daemon                                *\00"
@global_var_10ab4.43 = constant [83 x i8] c"*                              Licence Request                                   *\00"
@global_var_10b08.45 = constant [83 x i8] c"*                                Version 1.0                                     *\00"
@global_var_10bb0.49 = constant [83 x i8] c"*                                                                                *\00"
@global_var_10c04.51 = constant [83 x i8] c"*                    THIS SOFTWARE IS PROVIDED BY THE AUTHOR                     *\00"
@global_var_10c58.53 = constant [83 x i8] c"* ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,INCLUDING, BUT NOT LIMITED TO, *\00"
@global_var_10cac.55 = constant [83 x i8] c"* THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE *\00"
@global_var_10d00.57 = constant [83 x i8] c"* ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT,         *\00"
@global_var_10d54.59 = constant [83 x i8] c"* INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES             *\00"
@global_var_10da8.61 = constant [83 x i8] c"* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;   *\00"
@global_var_10dfc.63 = constant [83 x i8] c"* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND    *\00"
@global_var_10e50.65 = constant [83 x i8] c"* ON ANY THEORY OF LIABILITY,WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT      *\00"
@global_var_10ea4.67 = constant [83 x i8] c"* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS  *\00"
@global_var_10ef8.69 = constant [83 x i8] c"* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.                   *\00"
@global_var_10f4c.71 = constant [83 x i8] c"*              Use of this software is strictly for PowerTune.                   *\00"
@global_var_10fa0.73 = constant [83 x i8] c"* The distribution and sale of this Software is exclusive to the copyright       *\00"
@global_var_10ff4.75 = constant [83 x i8] c"*                        owner and his affilliates.                              *\00"
@global_var_11048.77 = constant [83 x i8] c"*      To purchase a legal copy ,please email Markus.Ippy1981@gmail.com          *\00"
@global_var_110a4.81 = constant [5 x i8] c"eth0\00"
@global_var_110ac.84 = constant [3 x i8] c"w+\00"
@global_var_110b0.86 = constant [15 x i8] c"Licrequest.lic\00"
@global_var_110c0.88 = constant [7 x i8] c"0x%02X\00"
@0 = external global i32
@1 = internal constant [8 x i8] c"\1B[1;36m\00"
@global_var_10a04.37 = constant i8* getelementptr inbounds ([8 x i8], [8 x i8]* @1, i32 0, i32 0)
@2 = internal constant [84 x i8] c"*                            \C2\A9 2018 Markus Ippy                                  *\00"
@global_var_10b5c.47 = constant i8* getelementptr inbounds ([84 x i8], [84 x i8]* @2, i32 0, i32 0)
@3 = internal constant [5 x i8] c"\1B[0m\00"
@global_var_1109c.79 = constant i8* getelementptr inbounds ([5 x i8], [5 x i8]* @3, i32 0, i32 0)
@4 = internal constant [64 x i8] c"\1B[33mLicence Request file Licence ---Licrequest.lic--- created \00"
@global_var_110c8.90 = constant i8* getelementptr inbounds ([64 x i8], [64 x i8]* @4, i32 0, i32 0)

define i32 @main(i32 %argc, i8** %argv) local_unnamed_addr {
dec_label_pc_105f8:
  %tmp348 = call i8 @__decompiler_undefined_function_3()
  %tmp349 = call i8 @__decompiler_undefined_function_3()
  %tmp350 = call i8 @__decompiler_undefined_function_3()
  %tmp351 = call i8 @__decompiler_undefined_function_3()
  %tmp352 = call i8 @__decompiler_undefined_function_3()
  %tmp353 = call i8 @__decompiler_undefined_function_3()
  %stack_var_-52 = alloca i32, align 4
  %v3_10608 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_10a04.37 to i8*))
  %v3_10610 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10a0c.39, i32 0, i32 0))
  %v3_10618 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10a60.41, i32 0, i32 0))
  %v3_10620 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10ab4.43, i32 0, i32 0))
  %v3_10628 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10b08.45, i32 0, i32 0))
  %v3_10630 = call i32 @puts(i8* bitcast (i8** @global_var_10b5c.47 to i8*))
  %v3_10638 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10bb0.49, i32 0, i32 0))
  %v3_10640 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10c04.51, i32 0, i32 0))
  %v3_10648 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10c58.53, i32 0, i32 0))
  %v3_10650 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10cac.55, i32 0, i32 0))
  %v3_10658 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10d00.57, i32 0, i32 0))
  %v3_10660 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10d54.59, i32 0, i32 0))
  %v3_10668 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10da8.61, i32 0, i32 0))
  %v3_10670 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10dfc.63, i32 0, i32 0))
  %v3_10678 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10e50.65, i32 0, i32 0))
  %v3_10680 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10ea4.67, i32 0, i32 0))
  %v3_10688 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10ef8.69, i32 0, i32 0))
  %v3_10690 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10f4c.71, i32 0, i32 0))
  %v3_10698 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10fa0.73, i32 0, i32 0))
  %v3_106a0 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10ff4.75, i32 0, i32 0))
  %v3_106a8 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_11048.77, i32 0, i32 0))
  %v3_106b0 = call i32 @puts(i8* getelementptr inbounds ([83 x i8], [83 x i8]* @global_var_10a0c.39, i32 0, i32 0))
  %v3_106b8 = call i32 (i8*, ...) @printf(i8* bitcast (i8** @global_var_1109c.79 to i8*))
  %v3_106c8 = call i32 @socket(i32 2, i32 2, i32 0)
  %tmp362 = bitcast i32* %stack_var_-52 to i8*
  %v7_106e8 = call i8* @strncpy(i8* %tmp362, i8* getelementptr inbounds ([5 x i8], [5 x i8]* @global_var_110a4.81, i32 0, i32 0), i32 15)
  %v2_106fc = call i32 (i32, i32, ...) @ioctl(i32 %v3_106c8, i32 35111)
  %v1_10704 = call i32 @close(i32 %v3_106c8)
  %v6_10720 = call %_IO_FILE* @fopen(i8* getelementptr inbounds ([15 x i8], [15 x i8]* @global_var_110b0.86, i32 0, i32 0), i8* getelementptr inbounds ([3 x i8], [3 x i8]* @global_var_110ac.84, i32 0, i32 0))
  %v4_10728 = zext i8 %tmp353 to i32
  %v1_1072c = add nuw nsw i32 %v4_10728, 6
  %v7_1073c = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_1072c)
  %v4_10748 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v4_1074c = zext i8 %tmp352 to i32
  %v1_10750 = add nuw nsw i32 %v4_1074c, 6
  %v7_10760 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10750)
  %v4_1076c = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v4_10770 = zext i8 %tmp351 to i32
  %v1_10774 = add nuw nsw i32 %v4_10770, 6
  %v7_10784 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10774)
  %v4_10790 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_10798 = add nuw nsw i32 %v4_10728, 3
  %v7_107a8 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10798)
  %v4_107b4 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v4_107b8 = zext i8 %tmp350 to i32
  %v1_107bc = add nuw nsw i32 %v4_107b8, 3
  %v7_107cc = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_107bc)
  %v4_107d8 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v4_107dc = zext i8 %tmp349 to i32
  %v1_107e0 = add nuw nsw i32 %v4_107dc, 3
  %v7_107f0 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_107e0)
  %v4_107fc = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v4_10800 = zext i8 %tmp348 to i32
  %v1_10804 = add nuw nsw i32 %v4_10800, 3
  %v7_10814 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10804)
  %v4_10820 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_10828 = add nuw nsw i32 %v4_10770, 3
  %v7_10838 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10828)
  %v4_10844 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_1084c = add nuw nsw i32 %v4_1074c, 3
  %v7_1085c = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_1084c)
  %v4_10868 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_10870 = add nuw nsw i32 %v4_107b8, 6
  %v7_10880 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10870)
  %v4_1088c = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_10894 = add nuw nsw i32 %v4_10800, 1
  %v7_108a4 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10894)
  %v4_108b0 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v7_108c8 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10774)
  %v4_108d4 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_108dc = add nuw nsw i32 %v4_1074c, 2
  %v7_108ec = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_108dc)
  %v4_108f8 = call i32 @fputc(i32 44, %_IO_FILE* %v6_10720)
  %v1_10900 = add nuw nsw i32 %v4_10728, 2
  %v7_10910 = call i32 (%_IO_FILE*, i8*, ...) @fprintf(%_IO_FILE* %v6_10720, i8* getelementptr inbounds ([7 x i8], [7 x i8]* @global_var_110c0.88, i32 0, i32 0), i32 %v1_10900)
  %v3_10918 = call i32 @puts(i8* bitcast (i8** @global_var_110c8.90 to i8*))
  call void @exit(i32 1)
  ret i32 ptrtoint (i32* @0 to i32)
}

declare i32 @printf(i8*, ...) local_unnamed_addr

declare %_IO_FILE* @fopen(i8*, i8*) local_unnamed_addr

declare i32 @ioctl(i32, i32, ...) local_unnamed_addr

declare i32 @puts(i8*) local_unnamed_addr

declare void @exit(i32) local_unnamed_addr

declare i32 @fprintf(%_IO_FILE*, i8*, ...) local_unnamed_addr

declare i8* @strncpy(i8*, i8*, i32) local_unnamed_addr

declare i32 @fputc(i32, %_IO_FILE*) local_unnamed_addr

declare i32 @socket(i32, i32, i32) local_unnamed_addr

declare i32 @close(i32) local_unnamed_addr

declare i8 @__decompiler_undefined_function_3() local_unnamed_addr
