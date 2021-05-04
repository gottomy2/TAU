import pytest

testdata = [
    (-11, 20, 1, -220),
    ("123", 12, 0, 0)
]

testdata2 = [
    -20, 18, 0, 31, "string"
]


@pytest.mark.parametrize("a,b,c,expected", testdata)
def test_product(a, b, c, expected):
    product = a * b * c
    assert product == expected


@pytest.mark.parametrize("a", testdata2)
def test_num_interval(a):
    is_num_correct = 0
    if 15 < a > -1:
        is_num_correct = 1

    assert is_num_correct == 1
