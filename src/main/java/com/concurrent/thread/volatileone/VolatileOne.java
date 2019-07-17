package com.concurrent.thread.volatileone;
/**
 * @ClassName VolatileOne
 * @Author chenzhuo
 * @Version 1.0
 * @Date 2019-07-10 22:15
 *                                                ;   {external_word}
 *   0x000000010bab274f: je     0x000000010bab2793
 *   0x000000010bab2755: push   %rsi
 *   0x000000010bab2756: push   %rdx
 *   0x000000010bab2757: push   %rcx
 *   0x000000010bab2758: push   %r8
 *   0x000000010bab275a: push   %r9
 *   0x000000010bab275c: movabs $0x1095aa930,%rsi  ;   {metadata({method} {0x00000001095aa930} 'arraycopy' '(Ljava/lang/Object;ILjava/lang/Object;II)V' in 'java/lang/System')}
 *   0x000000010bab2766: mov    %r15,%rdi
 *   0x000000010bab2769: test   $0xf,%esp
 *   0x000000010bab276f: je     0x000000010bab2787
 *   0x000000010bab2775: sub    $0x8,%rsp
 *   0x000000010bab2779: callq  0x00000001070ed104  ;   {runtime_call}
 *   0x000000010bab277e: add    $0x8,%rsp
 *   0x000000010bab2782: jmpq   0x000000010bab278c
 *   0x000000010bab2787: callq  0x00000001070ed104  ;   {runtime_call}
 *   0x000000010bab278c: pop    %r9
 *   0x000000010bab278e: pop    %r8
 *   0x000000010bab2790: pop    %rcx
 *   0x000000010bab2791: pop    %rdx
 *   0x000000010bab2792: pop    %rsi
 *   0x000000010bab2793: lea    0x1f8(%r15),%rdi
 *   0x000000010bab279a: movl   $0x4,0x270(%r15)
 *   0x000000010bab27a5: callq  0x0000000106f46d70  ;   {runtime_call}
 *   0x000000010bab27aa: vzeroupper
 *   0x000000010bab27ad: movl   $0x5,0x270(%r15)
 *   0x000000010bab27b8: lock addl $0x0,(%rsp)
 *   0x000000010bab27bd: cmpl   $0x0,-0x45b5a57(%rip)        # 0x00000001074fcd70
 *                                                 ;   {external_word}
 **/
public class VolatileOne {
    static volatile VolatileOne volatileOne;

    public static void main(String[] args) {
        volatileOne = new VolatileOne();
    }
}
