package ru.fewizz.idextender.asm.transformer;

import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import ru.fewizz.idextender.asm.AsmUtil;
import ru.fewizz.idextender.asm.Constants;
import ru.fewizz.idextender.asm.IClassNodeTransformer;
import ru.fewizz.idextender.asm.Name;

public class VanillaS24PacketBlockActivation implements IClassNodeTransformer {

	@Override
	public void transform(ClassNode cn) {
		MethodNode method = AsmUtil.findMethod(cn, Name.packet_readPacketData);
		AsmUtil.transformIntConst(cn, method, 4095, Constants.BLOCK_ID_MASK);
		
		method = AsmUtil.findMethod(cn, Name.packet_writePacketData);
		AsmUtil.transformIntConst(cn, method, 4095, Constants.BLOCK_ID_MASK);
	}
	
}
