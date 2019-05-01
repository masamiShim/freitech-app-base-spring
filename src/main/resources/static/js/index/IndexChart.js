var IndexChart = function IndexChart(selector, data) {
    c3.generate({
        size: {
            height: 320
        },
        bindto: selector,
        data: {
            columns: data,
            types: {
                data1: 'area',
                data2: 'area-spline'
            }
        },
        axis: {
            y: {
                label: {
                    text: '発電量(kw)',
                    position: 'outer-middle'
                }
            }
        }
    })
};