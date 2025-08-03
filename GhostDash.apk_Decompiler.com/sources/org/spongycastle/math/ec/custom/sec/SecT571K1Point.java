package org.spongycastle.math.ec.custom.sec;

import org.spongycastle.math.ec.ECConstants;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.math.ec.ECFieldElement;
import org.spongycastle.math.ec.ECPoint;
import org.spongycastle.math.raw.Nat576;

public class SecT571K1Point extends ECPoint.AbstractF2m {
    public SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this(eCCurve, eCFieldElement, eCFieldElement2, false);
    }

    public SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2);
        if ((eCFieldElement == null) == (eCFieldElement2 != null ? false : true)) {
            this.withCompression = z;
            return;
        }
        throw new IllegalArgumentException("Exactly one of the field elements is null");
    }

    SecT571K1Point(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr, boolean z) {
        super(eCCurve, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        this.withCompression = z;
    }

    /* access modifiers changed from: protected */
    public ECPoint detach() {
        return new SecT571K1Point((ECCurve) null, getAffineXCoord(), getAffineYCoord());
    }

    public ECFieldElement getYCoord() {
        ECFieldElement eCFieldElement = this.x;
        ECFieldElement eCFieldElement2 = this.y;
        if (isInfinity() || eCFieldElement.isZero()) {
            return eCFieldElement2;
        }
        ECFieldElement multiply = eCFieldElement2.add(eCFieldElement).multiply(eCFieldElement);
        ECFieldElement eCFieldElement3 = this.zs[0];
        return !eCFieldElement3.isOne() ? multiply.divide(eCFieldElement3) : multiply;
    }

    /* access modifiers changed from: protected */
    public boolean getCompressionYTilde() {
        ECFieldElement rawXCoord = getRawXCoord();
        if (!rawXCoord.isZero() && getRawYCoord().testBitZero() != rawXCoord.testBitZero()) {
            return true;
        }
        return false;
    }

    public ECPoint add(ECPoint eCPoint) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        SecT571FieldElement secT571FieldElement;
        SecT571FieldElement secT571FieldElement2;
        SecT571FieldElement secT571FieldElement3;
        ECPoint eCPoint2 = eCPoint;
        if (isInfinity()) {
            return eCPoint2;
        }
        if (eCPoint.isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        SecT571FieldElement secT571FieldElement4 = (SecT571FieldElement) this.x;
        SecT571FieldElement secT571FieldElement5 = (SecT571FieldElement) eCPoint.getRawXCoord();
        if (!secT571FieldElement4.isZero()) {
            SecT571FieldElement secT571FieldElement6 = (SecT571FieldElement) this.y;
            SecT571FieldElement secT571FieldElement7 = (SecT571FieldElement) this.zs[0];
            SecT571FieldElement secT571FieldElement8 = (SecT571FieldElement) eCPoint.getRawYCoord();
            SecT571FieldElement secT571FieldElement9 = (SecT571FieldElement) eCPoint2.getZCoord(0);
            long[] create64 = Nat576.create64();
            long[] create642 = Nat576.create64();
            long[] create643 = Nat576.create64();
            long[] create644 = Nat576.create64();
            long[] precompMultiplicand = secT571FieldElement7.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement7.x);
            if (precompMultiplicand == null) {
                jArr = secT571FieldElement5.x;
                jArr2 = secT571FieldElement8.x;
            } else {
                SecT571Field.multiplyPrecomp(secT571FieldElement5.x, precompMultiplicand, create642);
                SecT571Field.multiplyPrecomp(secT571FieldElement8.x, precompMultiplicand, create644);
                jArr = create642;
                jArr2 = create644;
            }
            long[] precompMultiplicand2 = secT571FieldElement9.isOne() ? null : SecT571Field.precompMultiplicand(secT571FieldElement9.x);
            if (precompMultiplicand2 == null) {
                jArr4 = secT571FieldElement4.x;
                jArr3 = secT571FieldElement6.x;
            } else {
                SecT571Field.multiplyPrecomp(secT571FieldElement4.x, precompMultiplicand2, create64);
                SecT571Field.multiplyPrecomp(secT571FieldElement6.x, precompMultiplicand2, create643);
                jArr4 = create64;
                jArr3 = create643;
            }
            SecT571Field.add(jArr3, jArr2, create643);
            SecT571Field.add(jArr4, jArr, create644);
            if (!Nat576.isZero64(create644)) {
                if (secT571FieldElement5.isZero()) {
                    ECPoint normalize = normalize();
                    SecT571FieldElement secT571FieldElement10 = (SecT571FieldElement) normalize.getXCoord();
                    ECFieldElement yCoord = normalize.getYCoord();
                    ECFieldElement divide = yCoord.add(secT571FieldElement8).divide(secT571FieldElement10);
                    secT571FieldElement2 = (SecT571FieldElement) divide.square().add(divide).add(secT571FieldElement10);
                    if (secT571FieldElement2.isZero()) {
                        return new SecT571K1Point(curve, secT571FieldElement2, curve.getB(), this.withCompression);
                    }
                    secT571FieldElement3 = (SecT571FieldElement) curve.fromBigInteger(ECConstants.ONE);
                    secT571FieldElement = (SecT571FieldElement) divide.multiply(secT571FieldElement10.add(secT571FieldElement2)).add(secT571FieldElement2).add(yCoord).divide(secT571FieldElement2).add(secT571FieldElement2);
                } else {
                    SecT571Field.square(create644, create644);
                    long[] precompMultiplicand3 = SecT571Field.precompMultiplicand(create643);
                    SecT571Field.multiplyPrecomp(jArr4, precompMultiplicand3, create64);
                    SecT571Field.multiplyPrecomp(jArr, precompMultiplicand3, create642);
                    SecT571FieldElement secT571FieldElement11 = new SecT571FieldElement(create64);
                    SecT571Field.multiply(create64, create642, secT571FieldElement11.x);
                    if (secT571FieldElement11.isZero()) {
                        return new SecT571K1Point(curve, secT571FieldElement11, curve.getB(), this.withCompression);
                    }
                    SecT571FieldElement secT571FieldElement12 = new SecT571FieldElement(create643);
                    SecT571Field.multiplyPrecomp(create644, precompMultiplicand3, secT571FieldElement12.x);
                    if (precompMultiplicand2 != null) {
                        SecT571Field.multiplyPrecomp(secT571FieldElement12.x, precompMultiplicand2, secT571FieldElement12.x);
                    }
                    long[] createExt64 = Nat576.createExt64();
                    SecT571Field.add(create642, create644, create644);
                    SecT571Field.squareAddToExt(create644, createExt64);
                    SecT571Field.add(secT571FieldElement6.x, secT571FieldElement7.x, create644);
                    SecT571Field.multiplyAddToExt(create644, secT571FieldElement12.x, createExt64);
                    SecT571FieldElement secT571FieldElement13 = new SecT571FieldElement(create644);
                    SecT571Field.reduce(createExt64, secT571FieldElement13.x);
                    if (precompMultiplicand != null) {
                        SecT571Field.multiplyPrecomp(secT571FieldElement12.x, precompMultiplicand, secT571FieldElement12.x);
                    }
                    secT571FieldElement2 = secT571FieldElement11;
                    secT571FieldElement = secT571FieldElement13;
                    secT571FieldElement3 = secT571FieldElement12;
                }
                return new SecT571K1Point(curve, secT571FieldElement2, secT571FieldElement, new ECFieldElement[]{secT571FieldElement3}, this.withCompression);
            } else if (Nat576.isZero64(create643)) {
                return twice();
            } else {
                return curve.getInfinity();
            }
        } else if (secT571FieldElement5.isZero()) {
            return curve.getInfinity();
        } else {
            return eCPoint2.add(this);
        }
    }

    public ECPoint twice() {
        ECFieldElement eCFieldElement;
        ECFieldElement eCFieldElement2;
        ECFieldElement eCFieldElement3;
        if (isInfinity()) {
            return this;
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement4 = this.x;
        if (eCFieldElement4.isZero()) {
            return curve.getInfinity();
        }
        ECFieldElement eCFieldElement5 = this.y;
        ECFieldElement eCFieldElement6 = this.zs[0];
        boolean isOne = eCFieldElement6.isOne();
        if (isOne) {
            eCFieldElement = eCFieldElement6;
        } else {
            eCFieldElement = eCFieldElement6.square();
        }
        if (isOne) {
            eCFieldElement2 = eCFieldElement5.square().add(eCFieldElement5);
        } else {
            eCFieldElement2 = eCFieldElement5.add(eCFieldElement6).multiply(eCFieldElement5);
        }
        if (eCFieldElement2.isZero()) {
            return new SecT571K1Point(curve, eCFieldElement2, curve.getB(), this.withCompression);
        }
        ECFieldElement square = eCFieldElement2.square();
        if (isOne) {
            eCFieldElement3 = eCFieldElement2;
        } else {
            eCFieldElement3 = eCFieldElement2.multiply(eCFieldElement);
        }
        ECFieldElement square2 = eCFieldElement5.add(eCFieldElement4).square();
        if (!isOne) {
            eCFieldElement6 = eCFieldElement.square();
        }
        ECFieldElement add = square2.add(eCFieldElement2).add(eCFieldElement).multiply(square2).add(eCFieldElement6).add(square).add(eCFieldElement3);
        return new SecT571K1Point(curve, square, add, new ECFieldElement[]{eCFieldElement3}, this.withCompression);
    }

    public ECPoint twicePlus(ECPoint eCPoint) {
        if (isInfinity()) {
            return eCPoint;
        }
        if (eCPoint.isInfinity()) {
            return twice();
        }
        ECCurve curve = getCurve();
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return eCPoint;
        }
        ECFieldElement rawXCoord = eCPoint.getRawXCoord();
        ECFieldElement zCoord = eCPoint.getZCoord(0);
        if (rawXCoord.isZero() || !zCoord.isOne()) {
            return twice().add(eCPoint);
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        ECFieldElement rawYCoord = eCPoint.getRawYCoord();
        ECFieldElement square = eCFieldElement.square();
        ECFieldElement square2 = eCFieldElement2.square();
        ECFieldElement square3 = eCFieldElement3.square();
        ECFieldElement add = square2.add(eCFieldElement2.multiply(eCFieldElement3));
        ECFieldElement addOne = rawYCoord.addOne();
        ECFieldElement multiplyPlusProduct = addOne.multiply(square3).add(square2).multiplyPlusProduct(add, square, square3);
        ECFieldElement multiply = rawXCoord.multiply(square3);
        ECFieldElement square4 = multiply.add(add).square();
        if (square4.isZero()) {
            if (multiplyPlusProduct.isZero()) {
                return eCPoint.twice();
            }
            return curve.getInfinity();
        } else if (multiplyPlusProduct.isZero()) {
            return new SecT571K1Point(curve, multiplyPlusProduct, curve.getB(), this.withCompression);
        } else {
            ECFieldElement multiply2 = multiplyPlusProduct.square().multiply(multiply);
            ECFieldElement multiply3 = multiplyPlusProduct.multiply(square4).multiply(square3);
            return new SecT571K1Point(curve, multiply2, multiplyPlusProduct.add(square4).square().multiplyPlusProduct(add, addOne, multiply3), new ECFieldElement[]{multiply3}, this.withCompression);
        }
    }

    public ECPoint negate() {
        if (isInfinity()) {
            return this;
        }
        ECFieldElement eCFieldElement = this.x;
        if (eCFieldElement.isZero()) {
            return this;
        }
        ECFieldElement eCFieldElement2 = this.y;
        ECFieldElement eCFieldElement3 = this.zs[0];
        ECCurve eCCurve = this.curve;
        ECFieldElement[] eCFieldElementArr = {eCFieldElement3};
        return new SecT571K1Point(eCCurve, eCFieldElement, eCFieldElement2.add(eCFieldElement3), eCFieldElementArr, this.withCompression);
    }
}
