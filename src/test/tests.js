QUnit.test( "hello test", function( assert ) {
    gradeCalc();
    assert.equal(myGradesCalculate.average(), "Your average grade is 70.33333333333333.");
    assert.equal(myGradesCalculate.myGrades, undefined);
    assert.ok( 1 == "1", "Passed!" );
});